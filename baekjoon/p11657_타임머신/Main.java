package baekjoon.p11657_타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M; //정점,간선,시작점
    static List<Link> links = new ArrayList<>();
    static long[] answer;
    static final int MAXINF = (int) 1e12;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            links.add(new Link(start, dest, cost));
        }

        //answer배열 시작점-0, 이 외 정점 MAXINF로 초기화
        answer = new long[N + 1];
        for(int i=1; i<=N; i++){
            if(i==1) answer[i] = 0;
            else{
                answer[i] = MAXINF;
            }
        }
        bellmanFord();
    }

    static void bellmanFord() {
        for (int p = 1; p <= N; p++) { //정점의 개수만큼 반복
            boolean isChange = false; //마지막 p=N에서 바뀌었는지 확인
            for (int q = 0; q < links.size(); q++) {
                Link link = links.get(q);

                if (answer[link.start] != MAXINF && answer[link.dest] > answer[link.start] + link.cost) {
                    isChange = true;
                    if (p <= N - 1) { //결과값은 N-1일때의 결과값.
                        answer[link.dest] = answer[link.start] + link.cost;
                    }
                }
            }

            if (p == N) { //마지막 정점을 돌 때 N-1과의 비교.
                if (isChange == true) {
                    System.out.println(-1);
                    return;
                } else {
                    print();
                    return;
                }
            }
        }
    }
    static void print(){
        for(int i=2; i<=N; i++){
            long temp = answer[i];
            if(temp == MAXINF){
                sb.append("-1 ");
            }
            else{
                sb.append(answer[i]+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}

class Link{
    int start;
    int dest;
    int cost;
    public Link(int start, int dest, int cost) {
        this.start = start;
        this.dest = dest;
        this.cost = cost;
    }
}
