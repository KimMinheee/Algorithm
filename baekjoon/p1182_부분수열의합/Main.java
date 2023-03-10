package baekjoon.p1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N,S;
    static int[] data;
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        data = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, 0 );

        if(S==0) System.out.println(answer-1);
        else System.out.println(answer);
    }
    static void dfs(int depth, int sum, int idx){
        if(depth == N){
            if(sum == S){
                answer++;
            }
            return;
        }

        dfs(depth+1,sum,idx+1);
        dfs(depth+1,sum+data[idx],idx+1);
    }

}
