package baekjoon.p15664_N과M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * p15664_N과M(10)
 * : 같은 것이 있는 조합
 * - linkedHashSet을 활용한 풀이법.
 * - 백트래킹x (근데 거의 완탐임)
 */
public class Solution {
    static int n,m;
    static int[] data;
    static int[] answer;

    static LinkedHashSet<String> hashSet = new LinkedHashSet<>(); //정답(조합) 저장
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        data = new int[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        dfs(0,0);

        hashSet.forEach(System.out::println);
    }
    static void dfs(int idx, int depth){
        if(depth == m){
            StringBuilder sb = new StringBuilder();
            for(int a : answer){
                sb.append(a+" ");
            }
            hashSet.add(sb.toString());
            return;
        }

        for(int i = idx; i<n; i++){
            answer[depth] = data[i];
            dfs(i+1,depth+1);
        }
    }
}
