package baekjoon.p2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//인접 리스트, 방문처리 배열 사용하여 dfs 탐색 돌면서 cnt+1;
public class Main {
    static int N,M; //컴퓨터의 개수, 연결 정보 개수
    static List<List<Integer>> data = new ArrayList<>();
    static boolean[] check;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++){ //N+1
            data.add(new ArrayList<Integer>());
        }
        check = new boolean[N+1];

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            data.get(start).add(dest);
            data.get(dest).add(start);
        }

        dfs(1);
        System.out.println(answer);
    }
    static void dfs(int startCom){
        check[startCom] = true;
        for(int i=0; i<data.get(startCom).size();i++){
            int tmp = data.get(startCom).get(i);
            if(check[tmp] == false){
                answer++;
                dfs(tmp);
            }
        }
    }

}
