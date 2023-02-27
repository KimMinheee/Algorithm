package baekjoon.p11660_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [구간합] p11660 - 구간합구하기5
 * : 각 위치별 구간합을 미리 구해서 2차원 배열에 넣음.
 */
public class Main {
    static int N,M; //표의 크기, 연산 횟수
    static int[][] prefixSum;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        prefixSum = new int[N+1][N+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        updatePrefixSum();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(getPrefixSum(x1,y1,x2,y2)+ "\n");
        }
        System.out.println(sb.toString());
    }
    static void updatePrefixSum(){
        for(int a=1; a<=N; a++){
            for(int b=1; b<=N; b++){
                prefixSum[a][b] = prefixSum[a][b-1] + prefixSum[a-1][b] + arr[a-1][b-1] - prefixSum[a-1][b-1];
            }
        }
    }
    static int getPrefixSum(int x1, int y1, int x2, int y2){
        return prefixSum[x2][y2]
                - prefixSum[x1-1][y1-1]
                -(prefixSum[x2][y1-1]  - prefixSum[x1-1][y1-1] + prefixSum[x1-1][y2] - prefixSum[x1-1][y1-1]);
    }
}
