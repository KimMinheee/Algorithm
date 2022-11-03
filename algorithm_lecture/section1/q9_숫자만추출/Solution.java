package algorithm_lecture.section1.q9_숫자만추출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    //아스키 코드 값을 이용하는 풀이
    public static int solution(String data){
        char[] arr = data.toCharArray();
        int answer =0;
        for(char x : arr){
            if(x>=48 && x<=57) answer = answer*10 +(x-48);
        }
        return answer;
    }

    //isDigit과 Integer클래스를 이용하는 풀이.
    public static Integer solution2(String data){
        char[] arr = data.toCharArray();
        String answer = "";
        for(char x : arr){
            if(Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        System.out.println(solution(data));
    }
}
