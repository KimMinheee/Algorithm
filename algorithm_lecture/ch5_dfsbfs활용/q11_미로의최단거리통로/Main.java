package algorithm_lecture.ch5_dfsbfs활용.q11_미로의최단거리통로;

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

public class Main {
    public static int[][] map;
    public static boolean[][] visited;
    public static int min;
    public static int cnt;
    static int[][] dd = {{1,0},{0,1},{-1,0},{0,-1}}; //하,우,상,좌

    public static void bfs(int m, int n){
        Queue que = new LinkedList<>();
        que.offer(new Node(1,1,0));
        visited[1][1] = true; //방문처리

        while(!que.isEmpty()){
            Node node = (Node)que.poll();
            visited[node.x][node.y] = true;

            if(node.x==7 && node.y == 7) { //종료지점에 도달하면 data값 출력 후 종료
                min = node.data;
                return;
            }

            cnt = node.data+1; //누적 거리값 +1

            //현재 노드 기준 하,우,상,좌 순으로 노드 탐색
            for(int i=0; i<4; i++){
                int dx = node.x + dd[i][0];
                int dy = node.y + dd[i][1];

                if(dx<=0 || dy<=0 || dx>=8 || dy>=8) continue;

                if(map[dx][dy] == 0 && visited[dx][dy] == false) que.offer(new Node(dx,dy,cnt));
            }
        }
        if(min==0) min = -1;

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[8][8]; //default : 0
        visited = new boolean[8][8]; //false

        for(int i=1; i<8; i++){
           st = new StringTokenizer(br.readLine());
            for(int j=1; j<8; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(1,1);
        System.out.println(min);
    }

}
