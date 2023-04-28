package baekjoon.p7569_토마토;
/**
 * BOJ7569 - 토마토
 * : 1차 코드
 * - BFS 사용
 */

import java.util.*;
import java.io.*;
public class Main {
    static int N,M,H; //행, 열, 높이
    static List<int[][]> layerMap = new ArrayList<>();
    static Queue<Tomato> que = new LinkedList<>();
    static int[] dx = {0,0,1,-1}; //행
    static int[] dy = {1,-1,0,0}; //열
    static int answer = 0;
    static int yetTomato = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //열
        N = Integer.parseInt(st.nextToken()); //행
        H = Integer.parseInt(st.nextToken()); //높이

        //H개만큼 계층 입력받는다.
        for(int i=0; i<H; i++)
        {
            layerMap.add(new int[N][M]); //int[][] 생성

            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++){
                    int tomato = Integer.parseInt(st.nextToken());
                    layerMap.get(i)[n][m] = tomato;
                    if(tomato == 1) que.add(new Tomato(i,n,m,0));
                    if(tomato == 0) yetTomato++;
                }
            }
        }

        while (!que.isEmpty()){

            Tomato tomato = que.poll();
            int tLayer = tomato.layer;
            int tN = tomato.n; //행
            int tM = tomato.m; //열
            int tDay = tomato.day; //저장일


            //수행
            //1. 아래가 있는 경우
            if(tLayer > 0){
                if(layerMap.get(tLayer-1)[tN][tM] == 0 ){
                    layerMap.get(tLayer-1)[tN][tM] = 1;
                    yetTomato--;
                    que.add(new Tomato(tLayer-1,tN, tM,tDay+1));
                }
            }

            //2. 위가 있는 경우
            if(tLayer < H-1){
                if(layerMap.get(tLayer+1)[tN][tM] == 0){
                    layerMap.get(tLayer+1)[tN][tM] = 1;
                    yetTomato--;
                    que.add(new Tomato(tLayer+1,tN, tM, tDay+1));
                }
            }

            //3. N과 M의 범위를 넘어가지 않는 경우 (왼,오,앞,뒤)
            for(int i=0; i<4; i++){
                int newN = tN + dx[i];
                int newM = tM + dy[i];

                if(newN >=0 && newM >=0 && newN<N && newM<M){
                    if(layerMap.get(tLayer)[newN][newM] == 0 ){
                        layerMap.get(tLayer)[newN][newM] = 1;
                        yetTomato--;
                        que.add(new Tomato(tLayer,newN,newM, tDay+1));
                    }
                }
            }

            answer = tDay;
        }
        if(yetTomato != 0){
            //모두 익지 못한 경우
            answer = -1;
        }

        System.out.println(answer);
        br.close();
    }
}
class Tomato{
    int layer; //층
    int n; // 세로(행)
    int m; // 가로(열)
    int day; //누적 저장 일
    public Tomato(int layer, int n, int m, int day){
        this.layer= layer;
        this.n = n;
        this.m = m;
        this.day = day;
    }
}
