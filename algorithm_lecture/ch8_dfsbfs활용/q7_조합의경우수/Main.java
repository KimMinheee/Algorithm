package algorithm_lecture.ch8_dfsbfs활용.q7_조합의경우수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int r;
    static int dfs(int a, int b){
        if(b==0 ||a==1 ||a==b){
            return 1;
        }
        int p = dfs(a-1,b-1);
        int q = dfs(a-1, b);
        return p+q;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        System.out.println(dfs(n,r));
    }
}
