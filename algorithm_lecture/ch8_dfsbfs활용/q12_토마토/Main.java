package algorithm_lecture.ch8_dfsbfs활용.q12_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int x;
    int y;
    int cnt;
    public Point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class Main {
    static int m;
    static int n;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static void bfs(ArrayList tomatoes){
        Queue que = new LinkedList();
        int answer = 0;
        for(Object p : tomatoes){
            que.offer(p);
        }

        while(!que.isEmpty()){
            Point p = (Point) que.poll();
            for(int i=0; i<4; i++){
                int mx = p.x + dx[i];
                int my = p.y + dy[i];

                if(mx<0 || my<0 ||mx>=n || my>=m||map[mx][my]==-1) continue;
                if(map[mx][my]==0){
                    map[mx][my]=1;
                    que.offer(new Point(mx,my,p.cnt+1));
                }
            }
            answer = p.cnt;
        }
        boolean success = true;
        //todo : 2차원 배열에서 find 개선
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){
                    success =false;
                    break;
                }
            }
        }
        if(success) System.out.println(answer);
        else System.out.println(-1);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        ArrayList tomatoes = new ArrayList<>();

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 1) tomatoes.add(new Point(i,j,0));
                map[i][j] = a;
            }
        }
        bfs(tomatoes);
    }
}
