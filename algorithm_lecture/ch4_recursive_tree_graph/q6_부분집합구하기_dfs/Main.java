package algorithm_lecture.ch4_recursive_tree_graph.q6_부분집합구하기_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int num;
    static int [] ch;
    public static void dfs(int L){
        if(L == num+1){
            for(int i=1; i<num+1; i++){
                if(ch[i]==1) System.out.print(i+" ");
            }
            System.out.println("");
            return;
        }
        ch[L]=1;
        dfs(L+1);
        ch[L]=0;
        dfs(L+1);
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        ch = new int[num+1];

        dfs(1);
    }
}
