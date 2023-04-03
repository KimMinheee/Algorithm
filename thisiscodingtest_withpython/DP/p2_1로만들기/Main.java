package thisiscodingtest_withpython.DP.p2_1로만들기;

import java.util.*;
import java.io.*;

/**
 * bfs로 품.
 */
public class Main {
    static int num;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

//        dfs(num,0);
//        System.out.println(answer);
        bfs(num,0,0);
        System.out.println(answer);

    }
    static void dfs(int num, int depth){ //시간초과발생
        if(num == 1){
            answer = Math.min(answer,depth);
            return;
        }

            if(num % 5== 0) dfs(num/5,depth+1);
            if(num % 3== 0) dfs(num/3, depth+1);
            if(num % 2== 0) dfs(num/2, depth+1);
            dfs(num-1, depth+1);

    }
    static void bfs(int num, int depth, int operation){

        Queue<Node> que = new LinkedList<>();
        if(num % 5 == 0) que.offer(new Node(num/5, depth+1,1));
        if(num % 3 == 0) que.offer(new Node(num/3, depth+1, 2));
        if(num % 2 == 0) que.offer(new Node(num/2, depth+1, 3));
        que.offer(new Node(num-1,depth+1, 4));

        while(!que.isEmpty()){
            Node node = que.poll();

            if(node.num == 1){
                answer = node.depth;
                return;
            }

            if(node.num % 5 == 0) que.offer(new Node(node.num/5, node.depth+1,1));
            if(node.num % 3 == 0) que.offer(new Node(node.num/3, node.depth+1,2));
            if(node.num % 2 == 0) que.offer(new Node(node.num/2, node.depth+1,3));
            que.offer(new Node(node.num-1,node.depth+1, 4));
        }
    }
}
class Node{
    int num;
    int depth;
    int operation;

    public Node(int num, int depth, int operation){
        this.num = num;
        this.depth = depth;
        this.operation = operation;
    }
}
