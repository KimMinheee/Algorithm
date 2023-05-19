package baekjoon.p26071_오락실에간총총이;
/**
 * BOJ26071 - 오락실에 간 총총이
 * - BFS(상,하,좌,우),
 * - map을 매개변수로 들고다녀야 함. 이전 턴에서 갱신되면 안된다.
 * - 탈출 조건 : map에서 G가 하나일 때 탈출
 */

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {0,0,-1,1}; //우, 좌, 상, 하
    static int[] dy = {1,-1,0,0};
    static String[][] map;
    static List<Point> gomgoms = new ArrayList<>();


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];


        for(int i=0; i<N; i++){
            map[i] = br.readLine().split("");
            for(int j=0; j<N; j++){
                if(map[i][j].equals("G")) gomgoms.add(new Point(i,j));
            }
        }

        bfs();
        br.close();


    }
    static void bfs(){
        boolean[][] check = new boolean[N][N];
        Queue<Round> que = new LinkedList<>();


        //처음 곰곰의 위치를 모두 큐에 삽입
        for(int i=0; i<gomgoms.size(); i++){
            que.add(new Round(gomgoms.get(i).x, gomgoms.get(i).y, map,0, check));
        }

        while(!que.isEmpty()){
            Round r = que.poll();
            if(r.isFinish(N)){
                System.out.println(r.count);
                return;
            }

            //우,좌,상,하 탐색 시작
            for(int i=0; i<4; i++){
                if(i == 0 && r.y < N-1){
                    int tx = r.x + dx[i];
                    int ty = r.y + dy[i];

                    if(r.check[tx][ty]) continue;

                    String[][] copyMap = r.map.clone();
                    boolean[][] copyCheck = r.check.clone();
                    copyMap[r.x][r.y] = ".";
                    copyMap[tx][ty] = "G";
                    copyCheck[tx][ty] = true;
                    que.add(new Round(tx,ty,copyMap,r.count+1,copyCheck));
                }
                else if(i==1 && r.y > 0){
                    int tx = r.x + dx[i];
                    int ty = r.y + dy[i];

                    if(r.check[tx][ty]) continue;

                    String[][] copyMap = r.map.clone();
                    boolean[][] copyCheck = r.check.clone();
                    copyMap[r.x][r.y] = ".";
                    copyMap[tx][ty] = "G";
                    copyCheck[tx][ty] = true;
                    que.add(new Round(tx,ty,copyMap,r.count+1, copyCheck));
                }
                else if(i==2 && r.x > 0){
                    int tx = r.x + dx[i];
                    int ty = r.y + dy[i];

                    if(r.check[tx][ty]) continue;

                    String[][] copyMap = r.map.clone();
                    boolean[][] copyCheck = r.check.clone();

                    copyMap[r.x][r.y] = ".";
                    copyMap[tx][ty] = "G";
                    copyCheck[tx][ty] = true;
                    que.add(new Round(tx,ty,copyMap,r.count+1, copyCheck));
                }
                else if(i==3 && r.x < N-1){
                    int tx = r.x + dx[i];
                    int ty = r.y + dy[i];

                    if(r.check[tx][ty]) continue;
                    boolean[][] copyCheck = r.check.clone();

                    String[][] copyMap = r.map.clone();
                    copyMap[r.x][r.y] = ".";
                    copyMap[tx][ty] = "G";
                    copyCheck[tx][ty] = true;
                    que.add(new Round(tx,ty,copyMap,r.count+1,copyCheck));
                }
            }

        }
    }

}
class Point{
    int x; //행
    int y; //열
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Round{
    int x;
    int y;
    String[][] map;
    int count;
    boolean[][] check;
    public Round(int x, int y, String[][] map, int count, boolean[][] check){
        this.x = x;
        this.y = y;
        this.map = map;
        this.count = count;
        this.check = check;
    }

    public boolean isFinish(int N){
        int GCount = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(this.map[i][j] == "G") GCount++;
            }
        }
        if(GCount == 1) return true;
        else return false;
    }
}
