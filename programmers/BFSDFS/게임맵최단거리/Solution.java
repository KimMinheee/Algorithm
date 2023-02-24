package programmers.BFSDFS.게임맵최단거리;

import java.util.*;

/**
 * 프로그래머스 - 게임 맵 최단 거리
 * 1. cnt값 끌고 다니기
 * 2. 시작위치가 cnt 1임 주의
 */
class Solution {
    static int answer = -1;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;

    public int solution(int[][] maps) {

        visited = new boolean[maps.length][maps[0].length];
        bfs(maps);

        return answer;
    }

    static void bfs(int[][]maps){
        Queue<Point> que = new LinkedList<>();
        int cnt =1;
        visited[0][0] = true;
        que.add(new Point(0,0,cnt)); //시작 위치

        while(!que.isEmpty()){
            Point point = que.poll();
            for(int i=0; i<4; i++){
                int mx = point.x + dx[i];
                int my = point.y + dy[i];
                int tmpCnt = point.cnt;

                if(mx<0 || my<0 || mx>= maps.length||my>=maps[0].length) continue; //범위 벗어남
                if(maps[mx][my] == 0) continue; //벽
                if(mx == maps.length-1 && my == maps[0].length-1){ //도착
                    answer = tmpCnt+1;
                    return;
                }
                if(visited[mx][my] == false){
                    visited[mx][my] = true;
                    que.add(new Point(mx,my,tmpCnt+1));
                }

            }
        }
    }
}
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