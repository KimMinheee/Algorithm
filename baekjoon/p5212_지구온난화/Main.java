package baekjoon.p5212_지구온난화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [시뮬레이션]p5212_지구온난화
 * - 인접한 3칸 or 4칸에 바다(.)인 경우 -> .으로 바꿈.
 * - 데이터배열, 결과값 배열 2가지 사용.
 * - 지도 축소 위한 첫번째 X발견 좌표, 마지막 X발견 좌표 사용.
 */
public class Main {
    static int R,C;  //행, 열
    static char[][] data;
    static char[][] answer;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        data = new char[R][C];
        answer = new char[R][C];


        //데이터 입력
        for(int a=0; a<R; a++){
            String[] tokens = br.readLine().split("");
            for(int b=0; b<C; b++){
                data[a][b] = tokens[b].charAt(0);
                answer[a][b] = tokens[b].charAt(0);
            }
        }

        getMap();
    }
    static void getMap(){

        for(int a=0; a<R; a++){
            for(int b=0; b<C; b++){
                    int cnt = 0;
                    for(int i=0; i<4; i++){//상하좌우 살핌
                        int mx = a + dx[i];
                        int my = b + dy[i];
                        if(mx<0 || my<0 ||my>=C || mx>=R ||data[mx][my]=='.'){
                            cnt++;
                        }
                    }
                    if(cnt>=3) answer[a][b] = '.';
                }
            }

        getRectangle();
    }
    static void getRectangle(){
        StringBuilder sb = new StringBuilder();

        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;

        for(int a=0; a<R; a++){
            for(int b=0; b<C; b++){
                //섬을 발견했을 때
                if(answer[a][b]=='X'){
                    minY = Math.min(minY,b);
                    minX = Math.min(minX,a);
                    maxY = Math.max(maxY,b);
                    maxX = Math.max(maxX,a);
                }
            }
        }

        for(int i=minX; i<=maxX; i++){
            for(int j=minY; j<=maxY; j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}