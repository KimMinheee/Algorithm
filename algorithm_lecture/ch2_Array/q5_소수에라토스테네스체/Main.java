package algorithm_lecture.ch2_Array.q5_소수에라토스테네스체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int solution(int num){
        int cnt = 0; // 소수의 개수

        //배열 선언 - 0으로 초기화 {0,0,0,...,0},i는 0부터 들어감. 0~n 까지의 자연수 이므로 n+1
        int arr[] = new int[num+1];

        //소수 여부 파악
        for(int i=2; i<num;i++){
            if(arr[i]==0){
                cnt++; //소수 개수 +1
                for(int j=i;j<num;j=j+i){
                    arr[j]=1; //소수의 배수인 경우 배열을 1로 변경.
                }
            }
        }
        return cnt;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(solution(num));
    }
}
