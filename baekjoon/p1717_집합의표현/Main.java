package baekjoon.p1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m; //n까지의 집합, m개의 연산
    static StringBuilder sb;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[n+1];

        //각자 자기자신 가리키도록 arr배열 초기화
        for(int i=1; i<=n; i++){
            arr[i]=i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(calc == 0){//합집합
                //a와 b의 크기 비교
                if(a<=b){
                    union(a,b);
                }
                else{
                    union(b,a);
                }
            }
            else{//같은 집합에 포함되어 있는지를 확인하는 연산
                if(find(a) == find(b)){
                    sb.append("YES"+"\n");
                }
                else{
                    sb.append("NO"+"\n");
                }
            }
        }
        System.out.println(sb.toString());

    }

    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        arr[bRoot] = aRoot;
    }
    static int find(int p){ //주어진 원소(p)의 루트노드 번호를 반환.
        if(p == arr[p]) return p;
        else return arr[p] = find(arr[p]);
    }
}
