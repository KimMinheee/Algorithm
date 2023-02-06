package baekjoon.p1922_네트워크연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M; //컴퓨터의 수, 연결할 수 있는 선의 수
    static PriorityQueue pq = new PriorityQueue<Edge>();
    static int[] parent;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];

        //parent 배열 초기화 -> 가리키는 부모의 값이 자기자신이 되도록 초기화
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        //입력
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //union(a,b);
            pq.add(new Edge(a,b,c));
        }
        System.out.println(getMst());


    }
    static long getMst(){
        long answer = 0L;
        while(!pq.isEmpty()){
            Edge edge = (Edge) pq.poll();

            int currentRootNode = find(edge.current);
            int destRootNode = find(edge.dest);

            if(currentRootNode != destRootNode){ //핵심 : 같은 집합에 속해있는지 확인하고 연결 해줘야 한다.
                answer+=edge.cost;
                union(edge.dest,edge.current);
            }
        }

        return answer;
    }

    //union
    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot;
    }
    //find
    static int find(int a){
        if(parent[a] == a) return a; //이미 루트노드;
        else{
            return parent[a]= find(parent[a]);
        }
    }
}
class Edge implements Comparable<Edge> {
    int current;
    int dest;
    int cost;
    public Edge(int current, int dest, int cost) {
        this.current = current;
        this.dest = dest;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o2) {
       return this.cost - o2.cost;
    }
}
