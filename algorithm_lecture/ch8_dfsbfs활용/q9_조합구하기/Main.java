package algorithm_lecture.ch8_dfsbfs활용.q9_조합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    static int n;
    static int m; //뽑는 개수

    static void dfs(int L,int p){
        System.out.println(L+"ㅋㅋㅋ"+p);
        if(p>n) return;
        if(L==m){
            for(int a : answer){
                System.out.print(a+" ");
            }
            System.out.println();
            return;
        }
        for(int i=p+1;i<=n;i++){
            answer[L] = i;
            dfs(L+1,i);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[m];
        dfs(0,0);
    }
}
