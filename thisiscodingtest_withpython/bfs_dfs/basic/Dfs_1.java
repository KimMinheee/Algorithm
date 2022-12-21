package thisiscodingtest_withpython.bfs_dfs.basic;

import java.util.ArrayList;

public class Dfs_1 {
    //node 연결 ver

    public static boolean[] visited = new boolean[9]; //방문 여부 boolean 배열 -> 0부터 시작이라 9개로 초기화. / default : false
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //겉 arrayList

    public static void dfs(int x){
        //현재 노드 x를 방문처리
        visited[x] = true;
        System.out.println(x + " ");

        //현재 노드 x에 연결된 노드 하나씩 재귀적으로 방문
        for(int i=0; i<graph.get(x).size(); i++){
            if(!visited[graph.get(x).get(i)])  dfs(graph.get(x).get(i)); //방문 안 했을 경우 재귀 반복
        }

    }

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

        dfs(1); //1부터 시작

    }
}
