package baekjoon.p1504_특정한최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * P1504_특정한최단경로
 * 주의) 두가지 경로 1-2-3-4와 1-3-2-4 둘 중 하나만 무한대여도 둘다 갈 수 없는 경로가 된다.
 *  -> ex) 1-2에서 무한대라면 1-3-2도 갈 수 없는 경로임(1-3-2가 1-2에 포함된다.)
 */

public class Main {
    static int N,E; //정점의 개수, 간선의 개수
    static List<List<Connect>> data = new ArrayList<>();
    static long answer ;
    static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++){
            data.add(new ArrayList<Connect>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //무향
            data.get(start).add(new Connect(end,cost));
            data.get(end).add(new Connect(start,cost));
        }

        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());


        long value1 = 0;
        value1 += dijkstra(1,n1);
        value1 += dijkstra(n1,n2);
        value1 += dijkstra(n2,N);

        long value2 = 0;
        value2 += dijkstra(1,n2);
        value2 += dijkstra(n2,n1);
        value2 += dijkstra(n1,N);

        //1-1-2-3 // 1-2-1-3
        //1-2-3-4 // 1-3-2-4
        if(value1>=Integer.MAX_VALUE && value2>=Integer.MAX_VALUE) answer = -1;

        else answer = Math.min(value1,value2);

        System.out.println(answer);
    }

    public static int dijkstra(int start, int end){
        boolean[] check = new boolean[N+1];
        int[] dist = new int[N+1];
        PriorityQueue<Connect> pq = new PriorityQueue<>();

        //출발점-0,나머지는 무한대
        for(int i=0; i<=N; i++){
            if(i == start) dist[i] = 0;
            else dist[i] = MAX;
        }
        pq.add(new Connect(start,0));

        while(!pq.isEmpty()){
            Connect c = pq.poll(); //가장 cost가 작은 값 뽑힌다.

            if(!check[c.dest]){
                check[c.dest] = true;
                for(Connect tmp : data.get(c.dest)){
                    dist[tmp.dest] = Math.min(dist[tmp.dest],tmp.cost+dist[c.dest]);
                    pq.add(new Connect(tmp.dest,dist[tmp.dest]));
                }
            }
        }
        //System.out.println(Arrays.toString(dist));

        return dist[end];
    }
}
class Connect implements Comparable<Connect>{
    int dest;
    int cost;

    public Connect(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Connect c){
        return this.cost - c.cost;
    }

}
