package swea.D1.p2050_알파벳을숫자로변환;

import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] data = br.readLine().split("");
        for(String c : data){
            sb.append((c.charAt(0)-'A'+1)+" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}