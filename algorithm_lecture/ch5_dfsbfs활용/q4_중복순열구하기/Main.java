package algorithm_lecture.ch5_dfsbfs활용.q4_중복순열구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] pm;
    static void dfs(int L){
       if(L == m){
           for(int x : pm) System.out.print(x+" ");
           System.out.println();
           return;
       }

        for(int i=1; i<=n; i++){
            pm[L] = i;
            dfs(L+1);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pm = new int[m];

        dfs(0);
    }
}
