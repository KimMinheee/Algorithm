package baekjoon.p15656_N과M7;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N과M(6) : 중복순열
 */

public class Main {
    static int N,M;
    static int[] data;
    static int[] answer;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N];
        answer = new int[M];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        dfs(0,0);

        System.out.println(sb.toString());
    }
    static void dfs(int idx, int depth){
        if(depth == M){
            for(int num : answer){
                sb.append(num+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0 ; i<N; i++){
                answer[depth] = data[i];
                dfs(i,depth+1);
        }
    }
}
