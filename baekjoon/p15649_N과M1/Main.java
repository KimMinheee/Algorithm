package baekjoon.p15649_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [백트래킹]15649_n과m(1)
 * - 순열 구하기
 * - visited 배열, 정답 배열(m사이즈)
 */

public class Main {
    static int N,M;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        answer = new int[M];

        permutation(0);
    }
    static void permutation(int depth){
        if(depth == M){
            for(int a : answer){
                System.out.print(a+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(visited[i] == false){
                visited[i] = true;
                answer[depth] = i+1;
                permutation(depth+1);
                visited[i] = false;
            }
        }
    }
}
