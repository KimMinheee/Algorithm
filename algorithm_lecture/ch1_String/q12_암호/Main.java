package algorithm_lecture.ch1_String.q12_암호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String solution(int num, String data){
        String answer = ""; //결과 담는 문자열
        String[] arr = new String[num];

        //데이터 split
        for(int i =0; i<num; i=i+1){
            arr[i] =  data.substring(i*7,i*7+7); //문자열 7자리로 substring

            //split한 7개의 문자(#,*)를 이진수화
            String tmp = "";
            for(char ch : arr[i].toCharArray()){
                if (ch =='#')
                    tmp += 1;
                else tmp +=0;
            }
            //이진수->10진수 & 아스키코드화
            answer += (char)Integer.parseInt(tmp,2);
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
