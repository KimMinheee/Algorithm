package baekjoon.p15652_N과M4;

/**
 * main.java에서 dfs for문 관련 중복 코드 정리한 ver.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    static int n,m;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[m];

        dfs(1,0);

        System.out.println(sb.toString());
    }
    static void dfs(int num, int depth){
        if(depth == m){
            for(int a : answer){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=num; i<n+1; i++){
            answer[depth] = i;
            dfs(i,depth+1);
        }
    }
}
