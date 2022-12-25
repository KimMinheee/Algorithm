package algorithm_lecture.ch4_recursive_tree_graph.q1_재귀함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void solution(int num){
        if(num==0) return;
        solution(num-1);
        System.out.print(num+" ");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        solution(num);
    }
}
