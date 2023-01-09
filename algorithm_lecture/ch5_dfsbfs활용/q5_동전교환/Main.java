package algorithm_lecture.ch5_dfsbfs활용.q5_동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int depth;
    int sum;
    public Node(int depth, int sum){
        this.depth = depth;
        this.sum = sum;
    }
}
public class Main{
    static int n; //동전의 개수
    static int total; //거슬러 줄 금액
    static int[] data; //동전의 종류
    static int bfs(){
        Queue que = new LinkedList<>();
        que.offer(new Node(0,0));
        while(!que.isEmpty()){
            Node t = (Node) que.poll();
            if(t.sum == total){
                return t.depth;
            }
            for(int j=0; j<n; j++){
                    que.offer(new Node(t.depth+1,t.sum+data[j]));
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        data = new int[n]; //동전의 종류 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        total = Integer.parseInt(br.readLine());

        System.out.println(bfs());
    }
}
