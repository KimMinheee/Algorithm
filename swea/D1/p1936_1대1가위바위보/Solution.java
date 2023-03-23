package swea.D1.p1936_1대1가위바위보;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write(getResult(A,B));
        bw.flush();
        bw.close();
        br.close();
    }
    static String getResult(int A, int B){
        //가위,바위,보 -> 1,2,3 , 비기는 경우 x
        if(A == 1){
            if(B == 2) return "B";
            else if(B == 3) return "A";
        }
        else if(A == 2){
            if(B == 1) return "A";
            else if(B==3) return "B";
        }
        else{
            if(B == 1) return "B";
            else if(B == 2) return "A";
        }
        return "";
    }
}
