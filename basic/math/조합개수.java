package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 조합개수 {
    public static void main(String[ ]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br. readLine());
        int r = Integer.parseInt(br.readLine());

        //조합의 개수
        System.out.println(getCombinationCount(n,r));
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
