package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 순열개수 {

    public static void main(String[ ]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br. readLine());
        int r = Integer.parseInt(br.readLine());

        //순열의 개수 구하기
        System.out.println(getPermutationCount(n,r));

    }


    static int getPermutationCount(int n, int r){ //순열의 개수
        //nPr = n!/(n-r)!
        return factorial(n) /factorial(n-r);
    }

    //팩토리얼 함수
    static int factorial(int a){
        if(a <= 1) return 1;
        return a * factorial(a-1);
    }

}
