package baekjoon.p15650_N과M2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [백트래킹]p15650_N과M(2)
 * - 조합
 * - visited x, answer만, depth
 */
public class Main {
    static int N,M;
    static int[] answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];

        for(int i=1; i<=N; i++){
            answer[0] = i;
            getCombination(i,1);
        }
    }
    static void getCombination(int idx, int depth){
        if(depth == M){
            for(int a : answer){
                System.out.print(a+" ");
            }
            System.out.println();
            return;
        }

        for(int i=idx+1; i<=N; i++){
            answer[depth] = i;
            getCombination(i,depth+1);
        }
    }
}
