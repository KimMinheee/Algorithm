package thisiscodingtest_withpython.DP.p2_1로만들기;

import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int[] table = new int[30001];

        for (int i = 2; i <= X; i++) {
            // 1을 빼는 경우
            table[i] = table[i-1] + 1;
            // 2의 배수인 경우
            if (i % 2 == 0) {
                table[i] = Math.min(table[i/2] + 1, table[i]);
            }
            // 3의 배수인 경우
            if (i % 3 == 0) {
                table[i] = Math.min(table[i/3] + 1, table[i]);
            }
            // 5의 배수인 경우
            if (i % 5 == 0) {
                table[i] = Math.min(table[i/5] + 1, table[i]);
            }
        }
        System.out.println(table[X]);

    }
}
