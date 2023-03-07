package baekjoon.p15657_N과M8;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * p15657_N과M(8)
 * : 중복조합
 */
public class Main {
    static int n,m;
    static int[] data;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        data = new int[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        for(int i=0; i<n; i++){
            answer[0] = data[i];
            dfs(i,1);
        }
        System.out.println(sb.toString());

    }
    static void dfs(int idx, int depth){
        if(depth == m){
            for(int a : answer){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx; i<n; i++){
            answer[depth] = data[i];
            dfs(i,depth+1);
        }
    }
}
