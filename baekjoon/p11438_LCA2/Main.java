package baekjoon.p11438_LCA2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * LCA(최소 공통 조상)
 * - 자신(index),depth를 저장
 * - 값을 입력 받고 부모(k=0,k=1,k=2..)의 배열값으로 세팅 k=16까지만 해도 충분함.(정점의 최대 depth : 50000, 2^16 = 65536)
 * - 최소 공통 조상을 구하고자 하는 두 노드 a,b를 입력받으면 각각 두 노드의 부모 노드,depth를 구한다.
 *      - dfs or bfs를 통해 depth값을 구하고 depth를 저장하는 배열에 저장한다.
 * - depth가 다르다면 같아질 때 까지 어느 한 노드를 올린다.(이 코드에서는 a를 더 깊은 노드로 둔다.)
 * - depth가 같아졌다면 하나씩(속도 개선하려면 2^0, 2^1, 2^2씩 올려서 비교한다.)
 */

public class Main {
    static int N,M;
    static int[] depth; //깊이 저장 배열
    static boolean[] visited; //깊이 저장하면서 dfs 돌 때 사용하는 배열
    static int[][] arr; //자신과 k=0, k=1,,,, k=16 일때 부모의 값을 저장
    static List<List<Integer>> adjList = new ArrayList<>();
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        depth = new int[N+1];
        visited = new boolean[N+1];
        arr = new int[17][N+1];

        for(int i=0; i<=N; i++){
            adjList.add(new ArrayList<Integer>());
        }

        //노드 연결 정보 입력
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a); //무향이라 양방향으로
        }

        //각 정점별 depth 구하기 & arr 배열에서 바로 위 부모배열(1(0)번째) 초기화
        visited[1] = true;
        getDepth(1,1);


        //각 정점별 1(0),2(1),4(2),8..번째 부모 구하기
        for(int i=1; i<=16; i++){
            for(int j=1; j<=N; j++){
                arr[i][j] = arr[i-1][arr[i-1][j]];
            }
        }

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            getLCA(a,b);
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb.toString());

    }
    static void getLCA(int a, int b){
        //1. a와 b의 depth를 구한다. a가 더 깊은 depth를 가지게 하고 그 차인 diff를 구한다.
        if(depth[a]< depth[b]){ //
            int tmp = a;
            a = b;
            b = tmp;
        }
        int diff = depth[a] - depth[b]; //depth 차

        //2. diff가 0이 될 때 까지 a를 올린다.
        int idx= 0;
        while(true){
            if(diff == 0) break;
            if(diff % 2 == 1){
                a = arr[idx][a];
            }
            diff /= 2;
            idx++;
        }


        //같은 노드인지 확인(레벨을 같게 한 후)
        if(a == b) {
            sb.append(b+"\n");
            return;
        }

        //3. a랑 b가 같아질 때까지 level을 동시에 올린다.
        int s = depth[a];
        int tmp = 0;
        for(int i=16; i>=0; i--){
            if(arr[i][a]!=arr[i][b]){
                a = arr[i][a];
                b = arr[i][b];
            }
            tmp = arr[i][a];
        }
        sb.append(tmp+"\n");
    }
    static void getDepth(int root, int depthValue){
        visited[root] = true;
        depth[root] = depthValue; //!!
        for(int i=0; i<adjList.get(root).size(); i++){
            int tmp = adjList.get(root).get(i);
            if(visited[tmp] == false){
                visited[tmp] = true;
                depth[tmp] = depthValue+1; //depth 배열 초기화
                arr[0][tmp] = root; //arr배열에서 바로 위 부모 배열 초기화
                getDepth(tmp,depthValue+1);
                visited[tmp] = false;
            }
        }
    }
}
