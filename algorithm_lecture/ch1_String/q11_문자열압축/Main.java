package algorithm_lecture.ch1_String.q11_문자열압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static String solution(String data){
        char[] arr = data.toCharArray();
        char tmp = arr[0];
        int cnt = 0;
        String answer = "";

        for(int i=0; i<arr.length; i++){
            if(arr[i] == tmp){
                cnt++;
            }
            else{
                if(cnt==1) answer += arr[i-1];
                else{
                    if(cnt == 1) answer=answer+arr[i-1];
                    else answer=answer+arr[i-1]+cnt;
                }
                cnt = 1;
            }
            tmp = arr[i]; //초기화
        }

        //마지막
        if(cnt>1) answer = answer + arr[arr.length-1] +cnt;
        else answer += arr[arr.length - 1];

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        System.out.println(solution(data));
    }
}
