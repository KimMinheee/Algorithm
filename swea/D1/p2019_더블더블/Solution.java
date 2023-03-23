package swea.D1.p2019_더블더블;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        getSquares(N);
        br.close();
    }
    static void getSquares(int N){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<=N; i++){
            sb.append((int) (Math.pow(2,i))+" ");
        }
        System.out.println(sb.toString());
    }
}
