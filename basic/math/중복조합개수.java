package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 중복조합의 공식 : nHr = (n+r-1)Cr
 * 기억안나면 그냥 나열하면서 count하는게 빠를 거 같다.
 */

public class 중복조합개수 {
    public static void main(String[ ]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br. readLine());
        int r = Integer.parseInt(br.readLine());

        //중복 순열 개수 구하기
        System.out.println(getDuplicateCombinationCount(n,r));
    }

    static int getDuplicateCombinationCount(int n, int r){
        return getCombinationCount(n+r-1,r);
    }

    static int getCombinationCount(int n, int r){ //조합의 개수
        //nCr = n!/((n-r)!*r!)
        return factorial(n) /(factorial(n-r) * factorial(r));
    }

    //팩토리얼 함수
    static int factorial(int a){
        if(a <= 1) return 1;
        return a * factorial(a-1);
    }
}
