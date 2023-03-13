package baekjoon.p1504_특정한최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 반례)
 7 7
 1 2 3
 3 2 5
 1 3 1
 6 5 3
 7 5 8
 5 4 2
 6 4 3
 2 6




 */

/**
 * p1504_특정한 최단 경로
 * : 다익스트라 알고리즘 활용
 */
public class Main {
    static int N,E; //정점의 개수, 간선의 개수
    static List<List<Edge>> data = new ArrayList<>();
    static List<Integer[]> answer = new ArrayList<>();
    static boolean[] check;
    static int mustGoA, mustGoB;
    static int sum = 0;
    static boolean readyToDest = false;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];

        //결과 저장 list 생성
        for(int i=0; i<=N; i++){
            data.add(new ArrayList<Edge>());
            answer.add(i, new Integer[N+1]);
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int vtx1 = Integer.parseInt(st.nextToken());
            int vtx2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            data.get(vtx1).add(new Edge(vtx2, cost));
            data.get(vtx2).add(new Edge(vtx1,cost));
        }

        st = new StringTokenizer(br.readLine());
        mustGoA = Integer.parseInt(st.nextToken());
        mustGoB = Integer.parseInt(st.nextToken());

        getShortestPaths(1);
        int beforeUsed = 1;

        //1. 두 정점에 갈 수 없는 경우(둘 다 INF)
        if(answer.get(1)[mustGoA] == Integer.MAX_VALUE && answer.get(1)[mustGoB] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        //첫번째
        if((answer.get(1)[mustGoA] < answer.get(1)[mustGoB])){ //a의 값이 더 작을 경우 -> a 먼저 사용
            if(!check[mustGoA] && answer.get(1)[mustGoA]!=Integer.MAX_VALUE){
                sum += answer.get(1)[mustGoA];
                getShortestPaths(mustGoA);
                beforeUsed = mustGoA;
            }
        }
        else{
            if(!check[mustGoB] && answer.get(1)[mustGoB] != Integer.MAX_VALUE){
                sum += answer.get(1)[mustGoB];
                getShortestPaths(mustGoB);
                beforeUsed = mustGoB;
            }
        }
        System.out.println("첫번째" + sum);

        //두번째
        if(beforeUsed == mustGoA ){ //이전에 간 곳이 mustGoA였다면? -> 이번엔 B를 가야한다.
            //3. 나머지 한 정점을 갈 수 없다면
            if(answer.get(beforeUsed)[mustGoB] == Integer.MAX_VALUE){
                System.out.println(-1);
                return;
            }

            if(!check[mustGoB]){
                sum += answer.get(beforeUsed)[mustGoB];
                getShortestPaths(mustGoB);
                beforeUsed = mustGoB;
            }
        }
        else{
            //3. 나머지 한 정점을 갈 수 없다면
            if(answer.get(beforeUsed)[mustGoA] == Integer.MAX_VALUE){
                System.out.println(-1);
                return;
            }
            if(!check[mustGoA]){
                sum += answer.get(beforeUsed)[mustGoA];
                getShortestPaths(mustGoA);
                beforeUsed = mustGoA;
            }
        }
        System.out.println("2번째" + sum);

        //must -> 마지막 정점.

        if(answer.get(beforeUsed)[N] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        sum += answer.get(beforeUsed)[N];
        System.out.println("마지막" + sum);

        System.out.println(sum);
    }
    static void getShortestPaths(int vtx){
        boolean[] visit = new boolean[N+1];
        PriorityQueue<Edge> que = new PriorityQueue<>();

        //세팅 : 시작점은 0, 나머지는 무한대
        for(int i=0; i<=N; i++){
            if(i == vtx) answer.get(vtx)[i] = 0;
            else answer.get(vtx)[i] = Integer.MAX_VALUE;
        }

        que.add(new Edge(vtx,0));

        while(!que.isEmpty()){
            Edge edge  = que.poll();
            int destVtx = edge.vertex;
            int cost = edge.cost;

            if(!visit[destVtx]){
                visit[destVtx] = true;
                for(Edge e : data.get(destVtx)){
                    int min = Math.min(answer.get(vtx)[e.vertex], e.cost+answer.get(vtx)[destVtx]);
                    answer.get(vtx)[e.vertex] = min;
                    que.add(new Edge(e.vertex,min));
                }
            }
        }

        System.out.println(Arrays.toString(answer.get(vtx)));
        check[vtx] = true;
    }
}
class Edge implements Comparable<Edge>{
    int vertex;
    int cost;

    public Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge edge){
        return this.cost - edge.cost; //cost 작은거(오름차순)
    }
}
