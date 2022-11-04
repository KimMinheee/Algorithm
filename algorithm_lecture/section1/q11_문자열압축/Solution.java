package algorithm_lecture.section1.q11_문자열압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String solution2(String data){
        int cnt = 1;
        data += " ";
        String answer = "";
        for(int i=0;i<data.length()-1;i++){
            if(data.charAt(i) == data.charAt(i+1)) cnt++;
            else{
                if(cnt>1) answer = answer + data.charAt(i) + cnt;
                else answer = answer + data.charAt(i);
                cnt = 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        System.out.println(solution2(data));
    }
}
