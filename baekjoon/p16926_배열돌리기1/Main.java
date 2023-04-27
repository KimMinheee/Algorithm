package baekjoon.p16926_배열돌리기1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [구현] 16926_배열돌리기1
 * 아이디어 :
 * - 반시계방향으로 돌릴 수 있는 사각형이 생기는 경우 -> Math.min(N,M)/2
 */

public class Main {
    static int N,M,R; //배열의크기 n*m, 회전수
    static int[][] map; // 2차원 배열
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];

        //입력
        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=R; i++){
            rotateMap();
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

        br.close();
    }

    static void rotateMap(){
        int rotateCount = Math.min(N,M) / 2;
        for(int group=1; group <= rotateCount; group++){//행렬 내 회전 그룹만큼 반복
            rotate(group);
        }
    }
    static void rotate(int group){
        //group - 1,2,3,..

        int next = map[group][group]; //[1][1], [2][2]
        //좌
        for(int i=group; i<(N-group+1); i++){
            int tmp = map[i+1][group]; //5
            map[i+1][group] = next;
            next = tmp;
        }



        //하
        for(int i=group; i<(M-group+1); i++){
            int tmp = map[N-group+1][i+1];//18
            map[N-group+1][i+1] = next;
            next = tmp;
        }


        //우
        for(int i=N-group+1; i>group; i--){
            int tmp = map[i-1][M-group+1];//16
            map[i-1][M-group+1] = next;
            next = tmp;
        }


        //상
        for(int i=M-group+1; i>group; i--){
            int tmp = map[group][i-1];
            map[group][i-1] = next;
            next = tmp;
        }

    }
}
