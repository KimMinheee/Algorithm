package algorithm_lecture.ch2_Array.q6_뒤집은소수;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static String solution(ArrayList arr){
        String answer = "";

        for(Object i : arr){
            int a = (Integer) i;
            int temp = a;//0이 아닌 수로 초기화
            String tmp = ""; //뒤집은 문자열 변수

            //1. 뒤집기
            while(temp!=0){
                tmp = tmp + (temp % 10);
                temp = temp / 10;

            }
            //2. 뒤집은 문자열(String) 숫자로 변경
            int j = Integer.parseInt(tmp);

            //3. 뒤집은 수가 소수인지 확인
            boolean isPrime = true;

            if(j==1 || j==0) isPrime = false;

            for(int p=2;p<j;p++){
                if(j ==2 || j==3 ||j==5||j==7) isPrime = true;
                else if(j%p==0) isPrime = false;
            }

            if(isPrime){
                answer = answer + j +" ";
            }

        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList arr = new ArrayList<Integer>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(solution(arr));
        bw.flush();
        bw.close();
    }
}
