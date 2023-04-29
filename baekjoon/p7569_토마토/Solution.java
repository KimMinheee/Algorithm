package baekjoon.p7569_토마토;

/**
 * BOJ7569 - 토마토
 * : 2차 개선 코드
 * - BFS 사용 & 3차원 배열
 */

import java.util.*;
import java.io.*;

public class Solution {
    static int M,N,H; // 열, 행, 높이
    static int[][][] map; //높이,행,열
    static Queue<Point> que = new LinkedList<>();
    static int yetTomato = 0;
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {1,-1,0,0,0,0}; //오른쪽,왼쪽,위,아래
    static int[] dz = {0,0,0,0,-1,1}; //하,상
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++){
                    int tomato = Integer.parseInt(st.nextToken());
                    map[h][n][m] = tomato;
                    if(tomato == 1) que.add(new Point(h,n,m));
                    if(tomato == 0) yetTomato++;
                }
            }
        }

        int answer = 0;
        while(!que.isEmpty()){
            Point p = que.poll();

            int idx = 0;
            while(idx < 6){//0,1,2,3,4,5
                int tx = p.x + dx[idx];
                int ty = p.y + dy[idx];
                int tz = p.z + dz[idx];

                if(tz>=0 && tz<H && tx>=0 && tx<N && ty>=0 && ty<M){
                    if(map[tz][tx][ty] == 0){
                        map[tz][tx][ty] = map[p.z][p.x][p.y] + 1;
                        answer = Math.max(answer, map[p.z][p.x][p.y] + 1);
                        yetTomato--;
                        que.add(new Point(tz,tx,ty));
                    }
                }
                idx++;
            }
        }

        if(yetTomato!=0) System.out.println(-1);
        else if(answer == 0) System.out.println(0);
        else System.out.println(answer-1);

        br.close();
    }
}
class Point{
    int x; //행
    int y; //열
    int z; //높이
    public Point(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
