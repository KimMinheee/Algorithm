package swea.D2.p1926_간단한369게임;


import java.io.*;

public class Solution {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        play369(N);
        br.close();
    }
    static void play369(int N){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            String tmp = String.valueOf(i);
            if(tmp.contains("3") || tmp.contains("6")||tmp.contains("9")){
                for(int j=0; j<tmp.length(); j++){
                    tmp = tmp.replaceAll("[369]","-");
                }
                tmp = tmp.replaceAll("[1245780]","");
            }
            sb.append(tmp+" ");
        }

        System.out.println(sb.toString());
    }
}
