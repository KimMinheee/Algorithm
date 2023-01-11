package algorithm_lecture.ch7_recursive_tree_graph.q12_경로탐색_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph; //그래프
    static int answer = 0; //총 가지수
    static boolean[] visited; //방문여부 배열
    static int n; //노드의 개수
    static int m; //간선의 개수

    public static int dfs(int data){
        visited[data] = true;

        if(data == n){
            answer++;
            System.out.println(Arrays.toString(visited));
        }

        for(int i =1; i<=n; i++){
            if(graph[data][i]==1 && visited[i]==false) dfs(i);
        }

        visited[data] = false;
        return answer;
    }

    public static int dfs2(int data){
        if(data == n) answer++;
        for(int i=1; i<=n; i++){
            if(graph[data][i] ==1 && visited[i]==false){
                visited[i] = true;
                dfs2(i);
                visited[i] = false; //dfs 함수 하나 다 돌면 false로 바꿔 줌.
            }
        }
        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //노드의 개수
        m = Integer.parseInt(st.nextToken()); //간선의 개수

        graph = new int[n+1][n+1]; //n+1 X n+1 정수형 배열로 초기화.
        visited = new boolean[n+1];

        //연결 정보 저장.
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        System.out.println(dfs(1));
    }
}
