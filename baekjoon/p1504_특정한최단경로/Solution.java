package baekjoon.p1504_특정한최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * p1504_특정한 최단 경로
 * - 다익스트라의 활용
 * - 로직)
 *  1. 각 정점(1, 중간지점1, 중간지점2)의 다익스트라 배열 값을 미리 구한다.
 *  2. 경우를 2가지로 나눈다.
 *      2-1. 중간지점이 둘 다 1이나 n이 아닌 경우
 *      2-2. 중간지점이 하나라도 1이나 n인 경우
 *     ---------------------------------------------------------------------
 *      2-1. 중간지점이 둘다 1이나 n이 아닌 경우:
 *          1->n1->n2->N과 1->n2->n1->N 두 방법 모두 확인하여 두 루트 중 최소를 찾는다.
 *          - 이때 고려한 부분은 다음과 같다.
 *              1. 1->n1으로 갈 수 있는가?
 *              2. n1->n2로 갈 수 있는가?
 *              3. n2 ->N 으로 갈 수 있는가?
 *      2-2. 중간지점이 하나라도 1이나 n인 경우:
 *          - n1과 n2가 1,n으로 구성된 경우 : 바로 1 -> N을 구한다.
 *          - n1이 1이나 n이 아닌 경우 : 1 -> n1 -> N을 구한다.
 *          - n2가 1이나 n이 아닌 경우 : 1 -> n2 -> N을 구한다.
 * - 주의)
 *  1. 아예 그래프 정보가 주어지지 않는 경우.(E가 0인 경우)
 *  2. 중간에 가다가 갈 수 없는 경로인 경우.
 *  3. sum값이 int 범위를 넘을 수 있다.
 */

public class Solution{
    static int N,E; //정점의 개수, 간선의 개수
    static List<List<Edge>> data = new ArrayList<>();
    static List<Integer[]> answer = new ArrayList<>();
    static int mustGoA, mustGoB;
    static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

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
        List<Integer> halfPoints = new ArrayList<>();

        if(mustGoA != 1 && mustGoA !=N){
            halfPoints.add(mustGoA);
        }
        if(mustGoB != 1 && mustGoB !=N){
            halfPoints.add(mustGoB);
        }

        //미리 각 정점의 최단경로 구해놓기
        getShortestPaths(1);
        getShortestPaths(mustGoA);
        getShortestPaths(mustGoB);

        long shortestValue = MAX;
        long sum = 0;
        if(halfPoints.size() >=2){//중간 지점 다 유효할 때(두 지점이 1이나 n이 아닐때)
            for(Integer num: halfPoints){
                sum = 0;
                if(answer.get(1)[num] >= MAX){
                    System.out.println(-1);
                    return;
                }
                else{
                    sum += answer.get(1)[num];
                } //1->첫 번째 중간지점

                //case1
                if(num == mustGoA){
                    long tmp = getValue(num,mustGoB,sum) ;
                    if(tmp == -1) return;
                    else sum = tmp;
                }

                //case2
                else if(num == mustGoB){
                    long tmp = getValue(num,mustGoA,sum);
                    if(tmp == -1) return;
                    else sum = tmp;
                }
                shortestValue = Math.min(shortestValue,sum);
            }
        }
        else{ //한 지점 or 두 지점 다 1이나 n일때)
            if(mustGoA == 1 || mustGoA == N){
                if(mustGoB == N || mustGoB == 1){ //중간 두 점이 양 끝
                    shortestValue = getValue(1,N,0);
                    if(shortestValue == -1) return;
                }
                else{ //mustGoB는 1이나 n이 아닐 때
                    if(answer.get(1)[mustGoB] >= MAX){
                        System.out.println(-1);
                        return;
                    }
                    else{
                        sum += answer.get(1)[mustGoB];
                    }

                    long tmp = getValue(mustGoB,N,sum);
                    if(tmp== -1) return;
                    else shortestValue = tmp;
                }
            }
            else { //mustGoA가 1이나 n이 아닐 때
                if(answer.get(1)[mustGoA] >= MAX){
                    System.out.println(-1);
                    return;
                }
                else{
                    sum +=answer.get(1)[mustGoA];
                }
                long tmp = getValue(mustGoA,N,sum);
                if(tmp == -1) return;
                else shortestValue = tmp;
            }
        }
        System.out.println(shortestValue);

    }
    static void getShortestPaths(int vtx){
        boolean[] visit = new boolean[N+1];
        PriorityQueue<Edge> que = new PriorityQueue<>();

        //세팅 : 시작점은 0, 나머지는 무한대
        for(int i=0; i<=N; i++){
            if(i == vtx) answer.get(vtx)[i] = 0;
            else answer.get(vtx)[i] = MAX;
        }

        que.add(new Edge(vtx,0));

        while(!que.isEmpty()){
            Edge edge  = que.poll();
            int destVtx = edge.vertex;

            if(!visit[destVtx]){
                visit[destVtx] = true;
                for(Edge e : data.get(destVtx)){
                    int min = Math.min(answer.get(vtx)[e.vertex], e.cost+answer.get(vtx)[destVtx]);
                    answer.get(vtx)[e.vertex] = min;
                    que.add(new Edge(e.vertex,min));
                }
            }
        }

    }
    static long getValue(int start, int dest, long sum){
        if(answer.get(start)[dest] >= MAX){
            System.out.println(-1);
            return -1;
        }
        else{
            sum += answer.get(start)[dest];
        }

        if(answer.get(dest)[N] >= MAX){
            System.out.println(-1);
            return -1;
        }
        else{
            sum += answer.get(dest)[N];
        }

        return sum;
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
