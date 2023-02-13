package baekjoon.p11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [트리의 부모 찾기]
 * - 인접 리스트, parent 배열, 방문처리배열
 */
public class Main {
    static int N;
    static List<List<Integer>> arr = new ArrayList();
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<Integer>());
        }
        parent = new int[N+1]; //0제외
        visited= new boolean[N+1];

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            arr.get(start).add(dest);
            arr.get(dest).add(start);
        }

        parent[1] = 1;
        getParent(1);
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }
    static void getParent(int root){
        visited[root] = true;
        for(int i=0; i<arr.get(root).size(); i++){
            int next = arr.get(root).get(i);
            if(visited[next] == false){
                parent[next] = root;
                getParent(next);
            }
        }
    }
}
