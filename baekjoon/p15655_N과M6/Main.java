package baekjoon.p15655_N과M6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N과M(6) : 조합
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

        for(int i=0; i<N; i++){
            answer[0] = data[i];
            dfs(i,1);
        }
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
        for(int i=idx+1 ; i<N; i++){
            answer[depth] = data[i];
            dfs(i,depth+1);
        }
    }
}
