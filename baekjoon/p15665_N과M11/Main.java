package baekjoon.p15665_N과M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * p15665_N과M(11)
 * : 같은 것이 있는 중복 순열
 * - 중복되는 값만 거르고 중복 순열 구하듯이!
 *
 * 주의)
 * hashSet은 순서를 보장하지 않는다.이 문제는 n의 크기가 7이하로 매우 작기때문에 hashSet을 사용해도 정렬이 되긴 하지만 16이상만 되더라도 이상한 순서로 정렬된다.
 * linkedHashSet+정렬 or treeSet을 사용해보자.
 */
public class Main {
    static int n,m;
    static Set<Integer> treeSet = new TreeSet<>(); //정렬하기위해
    static StringBuilder sb = new StringBuilder();
    static int[] answer;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[m];

        HashSet set = new HashSet();
        set.add(3);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num  = Integer.parseInt(st.nextToken());
            treeSet.add(num);
        }

        Integer[] arr = treeSet.stream().toArray(Integer[]::new); //hashSet을 배열로

        dfs(0,arr);
        System.out.println(sb.toString());
    }
    static void dfs(int depth, Integer[] arr){
        if(depth == m){
            for(int a : answer){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<arr.length; i++){
            answer[depth] = arr[i];
            dfs(depth+1,arr);
        }
    }
}
