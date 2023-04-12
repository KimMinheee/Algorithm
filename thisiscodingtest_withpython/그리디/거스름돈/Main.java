package thisiscodingtest_withpython.그리디.거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 문제)
 카운터에는 거스름돈으로 사용할 500원,100원, 50원, 10월짜리 동전이 무한히 존재한다고 가정한다.
 손님에게 거슬러 줘야 할 돈이 N원일 때 거슬러 줘야 할 돈정ㄴ의 최소 개수를 구하라.
 단, 거슬러줘야할 돈 N은 항상 10의 배수이다.

 입력) 1260
 출력) 6 (최소 동전의 개수)
 */
public class Main {
    static int N;
    static int[] coin = {500,100,50,10};
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<4; i++){
            answer += N/coin[i];

            N = N % coin[i];
        }
        System.out.println(answer);
    }
}
