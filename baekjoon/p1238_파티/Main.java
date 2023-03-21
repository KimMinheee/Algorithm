package baekjoon.p1238_파티;

import java.util.*;
import java.io.*;

public class Main {
    static int N,M,X;
    static List<List<Edge>> data = new ArrayList<>();
    static List<int[]> shortestDist = new ArrayList<>();
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++){
            data.add(new ArrayList<Edge>());
            shortestDist.add(new int[N+1]);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            data.get(start).add(new Edge(dest,cost)); //단방향
        }

        //각 정점별 최단거리 구하기
        for(int i=1; i<=N; i++){
            dijkstra(i);
        }

        int answer = 0;
        //정점별 왕복거리를 구하고 최댓값 확인
        for(int i=1; i<=N; i++){
            int wayGo = shortestDist.get(i)[X];
            int wayBack = shortestDist.get(X)[i];
            answer = Math.max(answer,(wayGo+wayBack));
        }

        System.out.println(answer);
        br.close();

    }
    static void dijkstra(int node){
        boolean[] check = new boolean[N+1];
        int[] dist = new int[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //시작 정점 -0, 나머지 무한대
        for(int i=0; i<=N; i++){
            if(i == node) dist[node] = 0;
            else dist[i] = MAX;
        }

        pq.add(new Edge(node,0));

        while(!pq.isEmpty()){
            Edge edge = pq.poll(); //cost가 가장 작은거 뽑힘.

            if(!check[edge.dest]){
                check[edge.dest] = true; //방문처리

                for(Edge tmp : data.get(edge.dest)){
                    //방문처리 다시 확인
                    if(!check[tmp.dest]){
                        dist[tmp.dest] = Math.min(dist[tmp.dest],dist[edge.dest]+tmp.cost); //원래, new
                        pq.add(tmp);
                    }
                }
            }
        }

        //리스트에 저장
        for(int i=1; i<=N; i++){
            shortestDist.get(node)[i] = dist[i];
        }
    }
}
class Edge implements Comparable<Edge>{
    int dest;
    int cost;

    public Edge(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e2){
        return this.cost-e2.cost;
    }
}
