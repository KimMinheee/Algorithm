package swea.p2070_큰놈작은놈같은놈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int testCase=0; testCase<T; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append("#"+(testCase+1)+" ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(num1 == num2){
                sb.append("="+"\n");
            }
            else if(num1 < num2){
                sb.append("<"+"\n");
            }
            else{
                sb.append(">"+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
