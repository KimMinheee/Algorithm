package basic.graph;


/*
 * Union-find
 * : find()함수에서 매번 root를 저장해주며 시간복잡도를 줄인다.
 * - BOJ 1717 - 집합의 표현을 예제로 코드를 작성한다.
 */

import java.io.*;
import java.util.*;
public class UnionFind {
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = i; //부모의 값이 자기자신이 되도록 세팅
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(type == 0) union(a,b);
            else{
                sb.append(isSameGroup(a,b)).append("\n");
            }
        }

        System.out.print(sb.toString());
        br.close();

    }
    //매개변수(num)의 root노드를 반환하는 함수
    static int findRoot(int num){
        if(arr[num] == num) return num; //종결 조건

        return arr[num] = findRoot(arr[num]); //root를 저장!!!
    }

    //두 정점 a,b를 같은 그룹으로 묶는 함수
    static void union(int a, int b){
        int aParent = findRoot(a);
        int bParent = findRoot(b);
        if(aParent != bParent){
            if(aParent < bParent) arr[bParent] = aParent;
            else arr[aParent] = bParent;
        }
    }

    //두 정점 a,b가 같은 그룹에 속해있는지 판단하는 함수
    static String isSameGroup(int a, int b){
        if(findRoot(a) != findRoot(b)) return "NO";
        else return "YES";
    }

}
