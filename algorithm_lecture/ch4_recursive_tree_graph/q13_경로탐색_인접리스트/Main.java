package algorithm_lecture.ch4_recursive_tree_graph.q13_경로탐색_인접리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//인접리스트(ArrayList) ver
public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int answer = 0; //총 가지수
    static boolean[] visited; //방문여부 배열
    static int n; //노드의 개수
    static int m; //간선의 개수

    public static int dfs(int data){
        if(data == n) answer++;

        for(int num : graph.get(data)){
            if(visited[num] == false){
                visited[num] = true;
                dfs(num);
                visited[num] = false;
            }
        }

        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //노드의 개수
        m = Integer.parseInt(st.nextToken()); //간선의 개수

        visited = new boolean[n+1];
        graph = new ArrayList<ArrayList<Integer>>();

        //리스트 초기화 - n+1개 만들어야 한다.
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        //arrayList에 연결 정보 저장.
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        visited[1]= true;
        System.out.println(dfs(1));

    }
}
