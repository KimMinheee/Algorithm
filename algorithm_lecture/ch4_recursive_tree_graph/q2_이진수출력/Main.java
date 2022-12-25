package algorithm_lecture.ch4_recursive_tree_graph.q2_이진수출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void recursive(int num){
        if(num==0) return;
        recursive(num/2);
        System.out.print((num%2));
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        recursive(num);
    }
}
