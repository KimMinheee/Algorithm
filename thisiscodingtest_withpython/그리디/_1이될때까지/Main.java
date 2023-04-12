package thisiscodingtest_withpython.그리디._1이될때까지;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //solution(N,M); //처음 코드
        solution2(N,M); //단축 코드

    }
    static void solution(int N, int M){ //처음 풀이 - 매번 if문으로 비교
        int answer = 0;
        while(true){
            if(N == 1) break;

            if(N % M == 0){
                N = N/M;
            }
            else{
                N -= 1;
            }

            answer++;
        }
        System.out.println(answer);
    }
    static void solution2(int N, int M){ //단축 코드
        int answer = 0;

        while(true){
            int target = (N / M) * M;
            answer += (N - target); //-1 연산 횟수(한번에 뺌)
            N = target;

            if(N < M) break; //N이 M보다 작을 때 break;
            N = N/M;
            answer += 1; // 나누기 M 연산
        }

        answer += (N-1); //N이 M보다 작을 때 튀어나오는 값 처리.


        System.out.println(answer);

    }
}
