package baekjoon.BFSDFS.q1743_음식물피하기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static int[][] map; //그래프
    public static boolean[][] visited; //방문 여부 배열
    public static int cnt = 0;
    public static int max=0; //max
    public static int[] dx = {0,0,-1,1}; //좌우상하
    public static int[] dy = {-1,1,0,0}; //좌우상하
    public static int m; //행 개수
    public static int n; //열 개수

    public static void solution(){
        //좌표는 (0,0) ~ (m-1,n-1)로 설정.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1 && visited[i][j]==false){
                    visited[i][j] = true;
                    cnt = 0;
                    dfs(i,j);
                    max = Math.max(cnt,max);
                }
            }
        }

    }
    public static void dfs(int i, int j){
        int mx ;
        int my ;
        cnt++;
        visited[i][j] = true;

        for(int k=0; k<4; k++){ //좌우상하 4번
            mx = i + dx[k];
            my = j + dy[k];

            if(mx>=0 && my>=0 && mx<m && my<n){ //범위 안
                if(map[mx][my] ==1 && visited[mx][my]==false){
                    dfs(mx,my);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n]; //default : 0
        visited = new boolean[m][m];

        for(int i=0; i<k; i++){ //음식물 쓰레기의 개수
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1; //음식물이 있는 좌표는 1
        }

        solution();

        System.out.println(max);

    }
}