package algorithm_lecture.ch8_dfsbfs활용.q6_순열구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;//총 개수
    static int M;//뽑는 수
    static int[] data; //n개의 자연수
    static int[] answer; //순열 저장
    static int[] check; //사용한 적 있는 수인지 체크

    static void dfs(int L){
        if(L==M){
            for(int x : answer) System.out.print(x +" ");
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(check[i]==0){
                check[i] = 1;
                answer[L] = data[i];
                dfs(L+1);
                check[i] = 0;
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N];
        check = new int[N];
        answer = new int[M];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
    }
}
