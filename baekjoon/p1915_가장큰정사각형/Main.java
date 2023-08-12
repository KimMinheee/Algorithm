package baekjoon.p1915_가장큰정사각형;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer;
    static int[][] map, dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        String input;
        
        for (int i = 1; i <= N; i++) {
            input = br.readLine();
            for (int j = 1; j <= M; j++) {
                dp[i][j] = map[i][j] = input.charAt(j - 1) - '0';
            }
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) { //1이라면
                    dp[i][j] = getSquare(i, j);
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        bw.write(String.valueOf(answer * answer));
        bw.flush();
        bw.close();
        br.close();
    }

    static int getSquare(int x, int y) {

        int check1 = dp[x][y - 1];
        int check2 = dp[x - 1][y];
        int check3 = dp[x - 1][y - 1];

        //셋 중 하나라도 0이면 바로 return 1;
        if (check1 == 0 || check2 == 0 || check3 == 0) return 1;

        return (Math.min(Math.min(check1, check2), check3)) + 1;

    }

}
