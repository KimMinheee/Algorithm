package baekjoon.p5014_스타트링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F,S,G,U,D; //총 층 수, 강호 층, 스타트링크 층 , 업, 다운
    static String answer="use the stairs";
    static boolean visited[];
    static int[] calc;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        calc = new int[]{U, -D};
        bfs(S,0); //강호
        System.out.println(answer);
    }
    static void bfs(int current,int cnt){
        Queue<Stair> que = new LinkedList();
        visited[current] = true;
        que.add(new Stair(current,cnt));
        while(!que.isEmpty()){
            Stair stair = que.poll();
            int currentFloor = stair.current;
            int currentCount = stair.cnt;

            if(currentFloor == G){
                answer = String.valueOf(currentCount);
                return;
            }
            else{
                currentCount++;
                for(int i=0; i<calc.length; i++){
                    int next = currentFloor+calc[i];
                    if(next <= F && next>=1){
                        if(visited[next] == false){
                            visited[next] = true;
                           que.add(new Stair(next,currentCount));
                        }
                    }
                }
            }
        }
    }
}
class Stair{
    int current;
    int cnt;
    public Stair(int current, int cnt) {
        this.current = current;
        this.cnt = cnt;
    }

}