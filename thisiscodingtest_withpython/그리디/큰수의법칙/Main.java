package thisiscodingtest_withpython.그리디.큰수의법칙;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;//데이터개수, 연산횟수, 연속가능
    static Integer[] data;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        //solution();
        solution2();

    }
    static void solution(){ //단순
        Arrays.sort(data,Collections.reverseOrder()); //Collections.reverseOrder()가 Comparator 객체
        int first = data[0];
        int second = data[1];

        int answer = 0;
        int kCount = 0;
        for(int i=1; i<=M; i++){
            if(kCount == K) {
                answer += second;
                kCount = 0;
                continue;
            }
            answer += first;
            kCount++;
        }

        System.out.println(answer);
    }

    static void solution2(){ //수열의 규칙성 이용
        Arrays.sort(data,Collections.reverseOrder()); //Collections.reverseOrder()가 Comparator 객체
        int firstValue = data[0];
        int secondValue = data[1];

        //가장 큰 수의 연산 횟수
        int firstCnt = M / (K+1) * K;
        firstCnt += M % (K+1);

        //두번째 큰 수의 연산 횟수
        int secondCnt = M /(K+1);

        int answer = firstCnt * firstValue + secondCnt * secondValue;
        System.out.println(answer);

    }
}
