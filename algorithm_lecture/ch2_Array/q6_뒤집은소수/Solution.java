package algorithm_lecture.ch2_Array.q6_뒤집은소수;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static boolean isPrime(int num){ //소수 판별 여부 함수
        if(num == 1) return false;
        for(int i=2;i<num;i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    public static String solution(int num, ArrayList<Integer> arr){
        String answer = "";
        for(int i =0; i<num; i++)
        {
            int tmp = (Integer) arr.get(i);
            int res =0;
            while(tmp>0){
                int t = tmp%10;
                res = res * 10 + t; //res => 뒤집은 수
                tmp = tmp/10;
            }
            if(isPrime(res)) answer = answer + res + " ";
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
        bw.write(solution(num,arr));
        bw.flush();
        bw.close();
    }
}
