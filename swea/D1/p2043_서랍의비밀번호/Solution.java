package swea.D1.p2043_서랍의비밀번호;

import java.io.*;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(P-K+1);
        br.close();
    }
}
