package baekjoon.p15651_N과M3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [백트래킹] p15651_N과M(3)
 * - 중복수열 : 같은 값을 여러번 고를 수 있다.
 * - answer 배열 o , visited x
 */
public class Main {
    static int N,M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];

        getDuplicatePermutation(0);
        System.out.println(sb.toString());
    }
    static void getDuplicatePermutation(int depth){
        if(depth == M){
            for(int a : answer){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            answer[depth] = i+1;
            getDuplicatePermutation(depth+1);
        }
    }
}
