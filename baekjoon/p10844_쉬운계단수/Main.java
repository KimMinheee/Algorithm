package baekjoon.p10844_쉬운계단수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int DIVIDE = 1_000_000_000;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10]; //0-9

        for(int i=1; i<10; i++){
            dp[1][i] = 1; //첫번째 자리 수
        }

        //두번째 자리 수 ~ N번째 자리 수
        for(int i = 2; i<=N; i++){

            for(int j=0; j<10; j++){

                if(j == 0){
                    dp[i][0] = dp[i-1][1] % DIVIDE;
                }
                else if(j == 9){
                    dp[i][9] = dp[i-1][8] % DIVIDE;
                }
                else{ // 2-8
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % DIVIDE;
                }

            }
        }

        int result = 0;
        for(int i=0; i<10; i++){
            result = (result + dp[N][i]) % DIVIDE;
        }
        System.out.println(result);
        br.close();
    }
}
