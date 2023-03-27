package swea.D2.p1986_지그재그숫자;

import java.io.*;

class Solution
{
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = Integer.parseInt(br.readLine());
            sb.append("#"+test_case+" ");
            sb.append(getValue(num)+"\n");
        }
        System.out.println(sb.toString());
    }

    static int getValue(int num){
        int answer = 0;
        for(int i=1; i<=num; i++){
            if(i%2 == 0) answer -= i;
            else answer += i;
        }
        return answer;
    }
}