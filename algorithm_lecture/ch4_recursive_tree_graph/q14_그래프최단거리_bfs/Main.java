package algorithm_lecture.ch4_recursive_tree_graph.q14_그래프최단거리_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int cnt=1; //간선 개수
    static int[] arr ; //간선 개수를 저장한 배열
    static boolean[] visited; //방문여부 배열
    static int n; //노드의 개수
    static int m; //간선의 개수

    public static void bfs(int data){
        Queue que = new LinkedList();
        que.offer(data);

        while(!que.isEmpty()){
            int len = que.size();
            int num =(int)que.poll();
            boolean isChange = false; //유의미한 경로가 아닌 경우 cnt+1을 막기위해 사용하는 변수.

            for(int i=0;i<len; i++){
                for(int a : graph.get(num)){
                    if(visited[a]==false){
                        que.offer(a);
                        visited[a] = true;
                        arr[a] = cnt;
                        isChange = true;
                    }
                }
            }
            if(isChange) cnt++;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //노드의 개수
        m = Integer.parseInt(st.nextToken()); //간선의 개수

        visited = new boolean[n+1];
        graph = new ArrayList<ArrayList<Integer>>();
        arr = new int[n+1];

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
        bfs(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+arr[i]);
        }

    }
}