package baekjoon.p1753_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * p1753_최단경로
 * - 다익스트라 알고리즘 + 우선순위 큐 사용
 * - 우선순위 큐에 들어 있는 값 다 뽑아 쓰면 정리되어있는 배열 순차적으로 출력.
 */
public class Main {
    static int V,E ; //정점의 개수, 간선의 개수
    static List<List<Edge>> info = new ArrayList(); //간선 연결 정보 저장하는 리스트
    static boolean[] visited; //방문 처리
    static int[] answer; // 최단 경로 저장하는 배열
    static PriorityQueue queue = new PriorityQueue<Edge>(); //최소힙(가중치 기준)
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        //방문처리, 최단경로 저장하는 결과 배열 초기화
        visited = new boolean[V+1];
        answer = new int[V+1];
        for(int i=1; i<=V; i++){
            answer[i] = Integer.MAX_VALUE; //무한대에 가까운 큰 값으로
        }

        //연결정보 저장하는 info 초기화
        for(int i=0; i<=V; i++){
            info.add(new ArrayList<>());
        }

        int startVtx = Integer.parseInt(br.readLine());
        answer[startVtx] = 0; //출발 노드의 배열 초기값을 0으로 바꾼다.

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            info.get(start).add(new Edge(dest,cost));
        }

        //큐에(시작점,시작점,0)으로 세팅
        queue.add(new Edge(startVtx,0));
        getShortestPaths();

        //출력
        for(int i=1; i<=V; i++){
            if(answer[i] == Integer.MAX_VALUE){
                sb.append("INF"+" ");
            }
            else{
                sb.append(answer[i]+" ");
            }

        }
        System.out.println(sb.toString());
    }

    static void getShortestPaths(){
        while(!queue.isEmpty()){
            Edge edge = (Edge) queue.poll();
            int dest = edge.dest;
            int cost = edge.cost;

            if(visited[dest]== false){
                //연결된 곳 다 큐에 넣음.
                for(Edge e : info.get(dest)){
                    answer[e.dest] = Math.min(answer[e.dest],answer[dest]+e.cost);
                    //위와같음! answer[e.dest] = Math.min(answer[e.dest],cost+e.cost);
                    queue.add(new Edge(e.dest,answer[e.dest]));
                }
            }
            visited[dest] = true; //현재 노드 방문처리
        }
    }
}
class Edge implements Comparable<Edge> {
    int dest;
    int cost;
    public Edge(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e2) {
        return this.cost - e2.cost;
    }
}
