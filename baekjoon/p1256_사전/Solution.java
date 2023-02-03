package baekjoon.p1256_사전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N,M,K;
    static int[][] dp = new int[201][201];

    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K>combination(N+M,M)) System.out.println(-1);
        else{
            query(N,M,K);
            System.out.println(sb.toString());
        }
    }
    public static void query(int n, int m, int k){ //n은 a의 개수, m은 b의 개수
        if(n+m == 0) {
            return;
        }
        else if(n==0) {
            sb.append("z");
            query(n,m-1,k);
        }
        else if(m==0){
            sb.append("a");
            query(n-1,m,k);
        }
        else{
            int limit  = combination(n +m -1,m);
            if(k <= limit){
                sb.append("a");
                query(n-1,m,k);
            }
            else{
                sb.append("z");
                query(n,m-1,k-limit);
            }
        }
    }


    public static int combination(int n, int r){
        if(n==r || r==0) return 1;
        else if(dp[n][r] != 0){
            return dp[n][r];
        }
        else{
            //combination으로 나올 수 있는 값이 너무 커서 k의 최대값 보다 크다면 그냥 k로 치환한다. (어차피 k이전의 값이 필요하지 k 이후의 대단히 큰 데이터는 필요x)
            return dp[n][r] = (int) Math.min(1e9,combination(n-1,r-1) + combination(n-1,r));
        }
    }
}
