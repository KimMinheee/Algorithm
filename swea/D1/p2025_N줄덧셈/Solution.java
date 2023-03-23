package swea.D1.p2025_N줄덧셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(getSum(num));
    }
    static int getSum(int num){
        int sum = 0;
        for(int d = num; d>=0; d--){
            sum+=d;
        }
        return sum;
    }
}
