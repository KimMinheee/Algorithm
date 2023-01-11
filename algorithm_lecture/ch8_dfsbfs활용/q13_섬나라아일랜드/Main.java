package algorithm_lecture.ch8_dfsbfs활용.q13_섬나라아일랜드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int m; //행
    int n; //열

    public Point(int m, int n){
        this.m = m;
        this.n = n;
    }
}
public class Main {
    static int num;
    static int[][] map;
    static boolean[][] visited;
    static int cnt=0;
    static int[] dx = {-1,0,1,0,-1,-1,1,1};//상,우,하,좌,대각선4개
    static int[] dy = {0,1,0,-1,-1,1,-1,1};
    static void bfs(int m, int n){
        Queue que = new LinkedList<>();
        que.offer(new Point(m,n));
        visited[m][n] = true;

        while(!que.isEmpty()){
            Point p = (Point) que.poll();
            for(int i=0; i<8;i++){
                int mx = p.m + dx[i];
                int my = p.n + dy[i];

                if(mx<1||my<1||mx>num||my>num) continue;
                if(map[mx][my]==1 && visited[mx][my]==false){
                    que.offer(new Point(mx,my));
                    visited[mx][my] = true;
                }
            }

        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        num = Integer.parseInt(br.readLine());
        map = new int[num+1][num+1];
        visited = new boolean[num+1][num+1];

        for(int i=1;i<=num;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=num; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=num;i++){
            for(int j=1; j<=num; j++){
                if(map[i][j] ==1 && visited[i][j]==false){
                    cnt++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(cnt);
    }
}
