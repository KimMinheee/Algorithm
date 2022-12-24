package thisiscodingtest_withpython.bfs_dfs.solution.미로탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[][] dd = {{1,0},{0,1},{-1,0},{0,-1}}; //하,우,상,좌
    static int cnt = 0;

    public static void bfs(int m, int n){
        Queue que = new LinkedList<>(); //큐

        //시작점 큐에 넣고 방문처리
        que.offer(new int[] {0,0});
        visited[0][0] = true;

        while(!que.isEmpty()){
            int[] temp = (int[]) que.poll(); //큐에서 꺼내기
            visited[temp[0]][temp[1]] = true; //방문처리
            cnt++;

            //하,우,상,좌 이동
            for(int i=0; i<4; i++){
                int dx = temp[0]+dd[i][0]; //x좌표
                int dy = temp[1]+dd[i][1]; //y좌표

                if(dx<0 || dy<0 || dx>=m || dy>=n) continue;

                if(map[dx][dy]==1 && visited[dx][dy]==false && dx>=temp[0] && dy>=temp[1]){
                    que.offer(new int[]{dx,dy});
                }
            }
        }
        System.out.println(cnt);

    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //행의 개수
        int n = Integer.parseInt(st.nextToken()); //열의 개수

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            String[] data = br.readLine().split("");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(data[j]);
            }
        }

        bfs(m,n);
    }
}
