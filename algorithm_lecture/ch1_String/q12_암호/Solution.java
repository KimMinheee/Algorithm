package algorithm_lecture.ch1_String.q12_암호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static String solution(int a,String data){
        String answer = "";
        for(int i=0; i<a; i++){
            String tmp = data.substring(0,7).replace('#','1').replace('*','0');
            int num = Integer.parseInt(tmp,2); //2진수->10진수
            answer += (char)num;
            data = data.substring(7);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String data = br.readLine();
        System.out.println(solution(a,data));
    }
}
