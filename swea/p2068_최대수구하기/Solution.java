package swea.p2068_최대수구하기;

import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#"+test_case+" ");
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<10; i++){
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max,num);
            }
            sb.append(max+"\n");
        }

        System.out.println(sb.toString());
    }
}