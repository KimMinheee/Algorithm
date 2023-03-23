package swea.D1.p2056_연월일달력;

import java.io.*;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int[] dayArr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            sb.append("#"+test_case+" ");
            String data = br.readLine();
            checkValidity(data);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void checkValidity(String data){
        //월 체크
        int month = Integer.parseInt(data.substring(4,6));
        if(month >=1 && month <=12){
            int day = Integer.parseInt(data.substring(6,8));
            if(day>=1 && day<=dayArr[month]){
                sb.append(data.substring(0,4)+"/");
                sb.append(data.substring(4,6)+"/");
                sb.append(data.substring(6,8)+"\n");
            }
            else sb.append(-1+"\n");

        }
        else{
            sb.append(-1+"\n");
        }

    }
}
