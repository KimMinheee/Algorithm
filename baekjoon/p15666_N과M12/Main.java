package baekjoon.p15666_N과M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * p15666_N과M(12)
 * : 같은 것이 있는 중복 조합
 * - 중복 제거한 후 중복조합 구하듯이!
 */
public class Main {
    static int n,m;
    static int[] answer;
    static Integer[] data;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> treeSet = new TreeSet();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            treeSet.add(num);
        }
        data = treeSet.stream()
                .toArray(Integer[]::new);

        dfs(0,0);
        System.out.println(sb.toString());
    }
    //중복조합 함수
    static void dfs(int idx, int depth){
        if(depth == m){
            for(int a : answer){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i<data.length; i++){
            answer[depth] = data[i];
            dfs(i,depth+1);
        }
    }

}
