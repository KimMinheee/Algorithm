package baekjoon.p1446_지름길;

import java.io.*;
import java.util.*;

/**
 * 방법 1)
 * - dest - start < cost이면 넣지 않는다.
 * - dist 배열을 0,무한대로 설정하는 것이 아닌, 0,1,2,3,4..순으로 순수 고속도로 거리에 대한 값을 저장한다.
 * - i를 도착지점까지 쭉 도는데 지름길의 시작점을 만난 경우
 *  - 시작점의 도착지점을 확인한다. dist[도착지점] vs dist[지름길시작지점] + cost; min값으로 dist[도착지점]을 수정한다.
 */

public class Solution {
    static int N,D;
    static List<List<Edge>> data = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int i=0; i<=D; i++){
            data.add(i,new ArrayList<Edge>());
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(dest - start < cost) continue;
            if(dest > D) continue;
            if(start > dest) continue;
            data.get(start).add(new Edge(dest, cost));
        }

        bw.write(String.valueOf(getShortestWay()));
        bw.flush();
        bw.close();
        br.close();
    }
    static int getShortestWay(){

        int dist[] = new int[D+1];
        for(int i=0; i<=D; i++){
            dist[i] = i;
        } //0,1,2,3,...으로 초기화한다.


        for(int i=0; i<=D; i++){
            if(data.get(i).size()>0){ //지름길이 존재한다면
                for(Edge e : data.get(i)){ //지름길 적용
                    int dest = e.dest;
                    int cost = e.cost;

                    dist[dest] = Math.min(dist[dest],dist[i]+cost);
                    for(int point = dest+1; point<=D; point++){//지름길의 도착지점이후 최종지점까지의 값 갱신
                        dist[point] = Math.min(dist[point-1]+1, dist[point]);
                    }
                }
            }
        }

        return dist[D];
    }

}
class Edge implements Comparable<Edge>{
    int dest;
    int cost;

    public Edge( int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e){
        if(this.dest - e.dest == 0) return (this.cost - e.cost);
        return this.dest-e.dest;
    }
}
