package swea.D1.p2072_홀수만더하기;

import java.io.*;
import java.util.*;

/**
 * p2072_홀수만더하기
 * : 정수, 문자열 처리
 */
class Solution
{
    public static void main(String args[]) throws IOException
    {
        //BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j=0; j<10; j++){
                int num = Integer.parseInt(st.nextToken());
                if( num %2 ==1 ) sum+= num;
            }
            sb.append("#"+(i+1)+" "+sum+"\n");
        }

        System.out.println(sb.toString());
    }
}