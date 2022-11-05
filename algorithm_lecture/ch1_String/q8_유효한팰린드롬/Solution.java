package algorithm_lecture.ch1_String.q8_유효한팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String solution(String data){
        String answer = "NO";
        data = data.toLowerCase().replaceAll("[^a-z]",""); //정규식 사용
        String tmp = new StringBuilder(data).reverse().toString();
        if(data.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        System.out.println(solution(data));
    }
}
