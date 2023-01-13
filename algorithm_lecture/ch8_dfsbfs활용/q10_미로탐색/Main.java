package algorithm_lecture.ch8_dfsbfs활용.q10_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[8][8];
    static boolean[][] visited = new boolean[8][8];
    static int answer=0;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void dfs(int m,int n){
        if(m<1 || n<1 || m>7 ||m>7) return; //범위를 벗어난 경우

        if(m==7 && n==7){
            answer++;
            return;
        }

        for(int i=0;i<4;i++){
            int x = m + dx[i];
            int y = n + dy[i];
            if(x<1 || y<1 || x>7 || y>7) continue;
            if(map[x][y]==0 && visited[x][y]==false){
                visited[x][y] = true;
                dfs(x,y);
                visited[x][y] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1; i<=7;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=7; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[1][1]=true;
        dfs(1,1);
        System.out.println(answer);
    }
}
