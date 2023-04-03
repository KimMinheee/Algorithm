package thisiscodingtest_withpython.BFSDFS.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs_1 {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();

        //현재 노드 큐에 넣기
        queue.add(x);
        //현재 노드 방문 처리
        visited[x] = true;

        while(!queue.isEmpty()){
            int p = queue.poll();

            System.out.print(p + " ");

            for(int i=0; i<graph.get(p).size(); i++){
                if(!visited[graph.get(p).get(i)]){
                    queue.add(graph.get(p).get(i)); //현재 노드와 연결된 노드 중 방문한 적 없는 노드만 queue에 넣기
                    visited[graph.get(p).get(i)] = true;
                }
            }
        }

    }

    //node 연결 ver
    public static void main(String[] args){
        //그래프 만들기
        for(int i=0; i<9; i++){
            graph.add(new ArrayList<Integer>()); // 안 ArrayList
        }

        //노드 연결
        //노드 1
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        //노드2
        graph.get(2).add(1);
        graph.get(2).add(7);

        //노드3
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6
        graph.get(6).add(7);

        // 노드 7
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1); //1부터 시작

    }
}
