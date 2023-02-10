package baekjoon.p11404_플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 플로이드 워셜 알고리즘 : 시간복잡도(O(N^3))
 * 그래프의 모든 정점-> 모든정점에 대한 최단거리를 구함.
 *
 * 1.for p 각 간선이 중간노드가 되는 경우 -> 정점 개수만큼 반복.
 *  2. for i(시작점)
 *      3.for j(도착지)
 */
public class Main {
    static int n, m;
    static int[][] arr; //최단거리 저장하는 2차원 배열
    static List<List<Edge>> list = new ArrayList<>();
    static final int MAX = (int) 1e9;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        //초기화
        arr = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<Edge>());
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) arr[i][j] = 0;
                else arr[i][j] = MAX;
            }
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Edge(dest,cost));
            arr[start][dest] = Math.min(arr[start][dest],cost);
        }
        getFloydWarshall();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] == MAX) arr[i][j] = 0;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    static void getFloydWarshall(){
        for(int p=1; p<=n; p++){ //각 정점이 중간노드가 되는 경우
            for(int q=1; q<=n; q++){ //시작점
                for(int r=1; r<=n; r++){ //도착지
                    if(r==q) continue;
                    if(arr[q][p]!=MAX && arr[p][r]!=MAX){ //중간경로를 거칠 수 있다면
                        int min = Math.min(arr[q][r],arr[q][p]+arr[p][r]);
                        arr[q][r] = min;
                    }
                }
            }
        }
    }
}
class Edge{
    int dest;
    int cost;

    public Edge(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}
