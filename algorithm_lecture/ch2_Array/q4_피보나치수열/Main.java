package algorithm_lecture.ch2_Array.q4_피보나치수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static String solution(int num){
        String answer = "";

        //피보나치 배열 담을 변수 선언
        int[] arr = new int[num];

        //초기화
        arr[0] = 1;
        arr[1] = 1;

        for(int i=2; i<num; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        answer = Arrays.toString(arr).replaceAll("[^0-9 ]","");

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(solution(num));

    }
}
