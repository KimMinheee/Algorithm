package swea.D1.p1545_거꾸로출력해보아요;

import java.io.*;

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        printReverse(N);

        br.close();
    }
    static void printReverse(int N){
        StringBuilder sb = new StringBuilder();
        for(int i=N; i>=0; i--){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}
