package swea.p2071_평균값구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int testCase = 0; testCase<T; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i=0; i<10; i++){
                int num = Integer.parseInt(st.nextToken());
                sum += num;
            }
            sb.append("#"+(testCase+1)+" "+String.format("%.0f",sum/(double)10)+"\n");

        }
        System.out.println(sb.toString());

    }
}
