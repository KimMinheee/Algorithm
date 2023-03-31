package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복순열개수 {
    public static void main(String[ ]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br. readLine());
        int r = Integer.parseInt(br.readLine());

        //중복 순열 개수 구하기
        System.out.println(getDuplicatePermutation(n,r));
    }

    static int getDuplicatePermutation(int n, int r){ //순열의 개수
        return (int) Math.pow(n,r);
    }
}
