package algorithm_lecture.section1.q9_숫자만추출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String solution(String data){
        char[] arr = data.toCharArray();
        String answer = "";
        for(char c : arr) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        int a = 0;
        while(answer.charAt(a)=='0'){
            a++;
        }
        return (String) answer.subSequence(a, answer.length());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        System.out.println(solution(data));
    }
}
