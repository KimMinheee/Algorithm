package swea.D1.p2046_스탬프찍기;

import java.io.*;

/**
 * 단순 for문
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#");
        }
        System.out.println(sb.toString());
        br.close();

    }
}