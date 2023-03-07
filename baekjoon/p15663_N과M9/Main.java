package baekjoon.p15663_N과M9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * p15663_N과M(9)
 * : 같은 것이 있는 순열
 */
public class Main {
    static int n,m;
    static HashMap<Integer,Integer> hashMap = new HashMap<>();
    static int[] data;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        data = new int[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());

            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }
            else{
                hashMap.put(num,1);
            }
        }
        dfs(0);
        System.out.println(sb.toString());

    }
    static void dfs(int depth){
        if(depth == m){
            for(int a : answer){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(Integer key : hashMap.keySet()){
            if(hashMap.get(key)>=1){
                hashMap.put(key, hashMap.get(key)-1);
                answer[depth] = key;
                dfs(depth+1);
                hashMap.put(key, hashMap.get(key)+1);
            }
        }

    }
}
