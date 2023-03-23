package swea.D1.p2029_몫과나머지출력하기;

import java.io.*;
import java.util.*;

/**
 입력)
 3
 9 2
 15 6
 369 15

 출력)
 #1 4 1
 #2 2 3
 #3 24 9
 */

public class Solution {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            sb.append("#"+test_case+" ");
            division(num1,num2);
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }
    static void division(int num1, int num2){
        int share = num1/num2;
        int rest = num1 % num2;
        sb.append(share+" "+rest);
        sb.append("\n");
    }
}
