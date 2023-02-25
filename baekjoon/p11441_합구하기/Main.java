package baekjoon.p11441_합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * p11441 - 합 구하기
 * - 구간합(특정 범위 i~j) 알고리즘 사용
 */
public class Main {
    static int N,M;
    static int[] data;
    static int[] sum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        data = new int[N];
        sum = new int[N+1]; //0도 있어야 함.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        getSumArr(); //부분합 구해놓기

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int prefix = getPrefix(a,b);
            sb.append(prefix+"\n");
        }
        System.out.println(sb.toString());

    }
    static int getPrefix(int a, int b){
        return sum[b]-sum[a-1];
    }
    static void getSumArr(){
        for(int i=1; i<N+1; i++){
            for(int j=0; j<i; j++){
                sum[i] += data[j];
            }
        }
    }
}
