package baekjoon.p21918_전구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] data;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N+1];

        //data배열 초기화
        st = new StringTokenizer(br.readLine());
        int idx = 1;
        while(st.hasMoreTokens()){
            data[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            solution(command,a,b);
        }

        for(int i=1; i<=N; i++){
            sb.append(data[i]+" ");
        }
        System.out.println(sb.toString());
    }
    static void solution(int command, int a, int b){
        if(command == 1){
            data[a] = b;
        }
        else if(command == 2){
            //a부터 b까지 반대로
            for(int i=a; i<=b; i++){
                if(data[i]==0) data[i]=1;
                else data[i] = 0;
            }
        }
        else if(command == 3){
            for(int i=a; i<=b; i++){
                data[i] = 0;
            }
        }
        else if(command == 4 ){
            for(int i=a; i<=b; i++){
                data[i] = 1;
            }
        }
    }
}
