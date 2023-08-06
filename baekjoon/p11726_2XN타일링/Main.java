package baekjoon.p11726_2XN타일링;
/**
 * [BOJ11726] - 2xn 타일링
 * 1. dp (피보나치 개념 이용)
 * 2. 모듈러 연산의 특성을 이용하여 연산시 모듈러 연산을 수행한 뒤 저장
 * 3. n = 1일때 고려(2는 존재하지 않는다.)
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 1 || n ==2){
            System.out.println(n);
            return;
        }

        int[] dp = new int[n+1]; //0은 제외
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
        br.close();
    }
}
