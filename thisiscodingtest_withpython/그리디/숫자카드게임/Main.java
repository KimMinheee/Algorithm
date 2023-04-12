package thisiscodingtest_withpython.그리디.숫자카드게임;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int answer = -1;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            answer = Math.max(Arrays.stream(map[i]).min().getAsInt(),answer);
        }

        System.out.println(answer);
    }
}
