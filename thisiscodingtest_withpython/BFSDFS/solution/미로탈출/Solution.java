package thisiscodingtest_withpython.BFSDFS.solution.미로탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x; //x값(행)
    int y; //y값(열)
    int data; //누적 거리 값

    public Node(int x, int y, int data){
        this.x = x;
        this.y = y;
        this.data = data;
    }
}

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[][] dd = {{1,0},{0,1},{-1,0},{0,-1}}; //하,우,상,좌
    static int cnt = 1;

    public static void bfs(int m, int n){
        Queue que = new LinkedList<>();
        que.offer(new Node(0,0,1));
        visited[0][0] = true; //방문처리

        while(!que.isEmpty()){
            Node node = (Node)que.poll();
            visited[node.x][node.y] = true;

            if(node.x==(m-1) && node.y == (n-1)) { //종료지점에 도달하면 data값 출력 후 종료
                System.out.println(node.data);
                return;
            }

            cnt = node.data+1; //누적 거리값 +1

            //현재 노드 기준 하,우,상,좌 순으로 노드 탐색
            for(int i=0; i<4; i++){
                int dx = node.x + dd[i][0];
                int dy = node.y + dd[i][1];

                if(dx<0 || dy<0 || dx>=m || dy>=n) continue;

                if(map[dx][dy] == 1 && visited[dx][dy] == false) que.offer(new Node(dx,dy,cnt));
            }
        }

    }

    public static void main(String[] args) throws IOException {
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
