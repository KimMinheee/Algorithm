package thisiscodingtest_withpython.bfs_dfs.solution.음료수얼려먹기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DFS ver
public class Main {
    public static int [][] map; //맵
    public static boolean [][] visited; //방문여부
    public static int[] dx = {0,0,-1,1}; //좌,우,상,하
    public static int[] dy = {-1,1,0,0};
    public static int m; //행의 개수
    public static int n; //열의 개수

    public static void dfs(int a, int b){
        visited[a][b] = true;

        for(int i=0; i<4; i++){
            int mx = a+dx[i];
            int my = b+dy[i];
            if(mx<0 || my <0 || mx>=m || my>=n) continue;

            if(map[mx][my]==0 && visited[mx][my]==false){
                visited[mx][my] = true;
                dfs(mx,my);
            }
        }
    }

    public static int solution(){
        int cnt = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==0 && visited[i][j]==false){
                    System.out.println(i + " "+j);
                    cnt++;
                    visited[i][j] = true;
                    dfs(i,j);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); //행 개수
        n = Integer.parseInt(st.nextToken()); //열 개수

        //map,visited 초기화
        map = new int[m][n];
        visited = new boolean[m][m];

        for(int i=0; i<m; i++){
            String[] data = br.readLine().split("");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(data[j]);
            }
        }

        System.out.println(solution());

    }
}
