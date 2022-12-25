package algorithm_lecture.ch4_recursive_tree_graph.q3_팩토리얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 1;

    public static void dfs(int num){
        if(num==0){
            System.out.println(cnt);
            return;
        }
        cnt  = cnt * num;
        dfs(num-1);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        dfs(num);
    }
}
