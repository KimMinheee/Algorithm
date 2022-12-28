package algorithm_lecture.ch4_recursive_tree_graph.q8_송아지찾기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int point; //현재 위치
    int trial; //실행 횟수

    public Node(int point, int trial){
        this.point = point;
        this.trial = trial;
    }
}

public class Main {
    protected static int cnt = 0; //점프 횟수
    protected static int a; //현수의 위치
    protected static int b; //송아지의 위치
    protected static int[] dx = {+5,+1,-1};
    protected static boolean[] visited = new boolean[10001]; //방문여부

    static int bfs(){
        Queue que = new LinkedList<>();
        que.offer(new Node(a,0));
        visited[a] = true;

        while(!que.isEmpty()){
            Node node = (Node) que.poll();

            cnt = node.trial+1;
            for(int d : dx){ //+5,+1,-1
                int mx = node.point + d;

                if(mx == b){ //송아지의 위치에 도착했다면
                    return node.trial+1;
                }

                if(mx<=0||mx>10000) continue;

                if(!visited[mx]){
                    que.offer(new Node(mx,cnt));
                    visited[mx] = true;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); //현수
        b = Integer.parseInt(st.nextToken()); //송아지

        System.out.println(bfs());
    }
}
