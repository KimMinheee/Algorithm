package baekjoon.p2775_부녀회장이될테야;

import java.io.*;

public class Main {

    public static int[][] dp = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        setApart();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    public static void setApart() {
        for (int i = 0; i < 15; i++) {
            dp[i][1] = 1; // i층 1호
            dp[0][i] = i; // 0층 i호
        }

        for (int i = 1; i < 15; i++) { // 1 - 14층
            for (int j = 2; j < 15; j++) { // 2 -14호
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j]; //점화식
            }
        }
    }

}
