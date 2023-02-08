package baekjoon.p11657_타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
5 8 1
1 2 7
1 3 5
1 4 3
4 5 -6
5 3 2
4 2 3
3 4 3
3 5 3
 */

/*
3 4 1
1 2 4
1 3 3
2 3 -1
3 1 -2
 */
/*
3 2 1
1 2 4
1 2 3
 */

/**
 * Bellman-Ford 알고리즘 기본 코드
 * 입력 : N(정점의 개수) | M(간선의 개수) | K(시작점) | (start(출발정점), dest(도착정점) ,cost(가중치))
 * 과정 : 함수를 실행하고 결과 배열에 각각 결과 값을 저장한다.
 *       1. 음의 순환이 있는 경우 : "음의 순환이 존재합니다"
 *       2. 시작점에서 갈 수 없는 경우 : INF값
 *       3. 갈 수 있는 경우 : 도출한 최단 거리 값
 * 출력 : 결과 배열을 출력한다.
 *
 * -------------------------------------------------------------
 * - edge(start,dest,cost)를 입력받은 순서대로 저장한 ArrayList 구조
 * - 결과 배열(계속 갱신되며 최종 적으로 출력하는)
 */
public class Basic {
    static int N,M; //정점,간선,시작점
    static List<Edge> edges = new ArrayList<>();
    static int[] answer;
    static final int MAXINF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        int startVtx = Integer.parseInt(st.nextToken()); //시작점

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start,dest,cost));
        }

        //answer배열 시작점-0, 이 외 정점 MAXINF로 초기화
        answer = new int[N+1];
        for(int i=1; i<=N; i++){
            if(i==startVtx) answer[i] = 0;
            else{
                answer[i] = MAXINF;
            }
        }

        bellmanFord(startVtx);
    }
    static void bellmanFord(int startVtx){
        for(int p=1; p<=N; p++){ //정점의 개수만큼 반복
            boolean isChange = false; //마지막 p=N에서 바뀌었는지 확인
            for(int q=0; q<edges.size(); q++){
                Edge edge = edges.get(q);

                if(edge.start!=MAXINF && answer[edge.dest]>answer[edge.start]+ edge.cost){
                    answer[edge.dest] = answer[edge.start] + edge.cost;
                    isChange = true;
                }

            }

            if(p==N ){ //마지막 정점을 돌 때 N-1과의 비교.
                if(isChange==true){
                    System.out.println("음의 순환이 존재합니다");
                    return;
                }
                else{
                    for(int i=1; i<answer.length; i++){
                        sb.append(answer[i]+" ");
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }
}
class Edge{
    int start;
    int dest;
    int cost;
    public Edge(int start, int dest, int cost) {
        this.start = start;
        this.dest = dest;
        this.cost = cost;
    }
}
