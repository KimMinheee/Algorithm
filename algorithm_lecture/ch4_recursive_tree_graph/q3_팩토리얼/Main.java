package algorithm_lecture.ch4_recursive_tree_graph.q3_팩토리얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 1;

    //내 풀이
    public static void dfs(int num){
        if(num==0){
            System.out.println(cnt);
            return;
        }
        cnt  = cnt * num;
        dfs(num-1);
    }

    //강의 풀이
    public static int dfs2(int n){
        if(n==1) return 1;
        else return n*dfs2(n-1);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        //dfs(num);
        System.out.println(dfs2(num));
    }
}
