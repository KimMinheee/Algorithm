package swea.D1.p1938_아주간단한계산기;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        sb.append(plus(num1,num2)+"\n");
        sb.append(minus(num1,num2)+"\n");
        sb.append(multiply(num1,num2)+"\n");
        sb.append(divide(num1,num2)+"\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int plus(int num1,int num2){ return (num1+num2);}
    static int minus(int num1,int num2){return (num1-num2);}
    static int multiply(int num1, int num2){return (num1*num2);}
    static int divide(int num1,int num2){return (num1/num2);}

}

