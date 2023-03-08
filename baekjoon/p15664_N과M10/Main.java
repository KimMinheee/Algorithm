package baekjoon.p15664_N과M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * p15664_N과M(10)
 * : 같은 것이 있는 조합
 - hashMap(데이터 개수 저장)과 중복되지 않는 값(key)들을 저장해놓은 배열을 이용해 같은 것이 있는 조합을 구한다.
 */

public class Main{
    static HashMap<Integer,Integer> hashMap = new HashMap<>();
    static List<Integer> arrList = new ArrayList<>(); //hashMap의 key값, 즉 데이터들의 배열
    static int n,m;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }
            else{
                arrList.add(num); //새로 받은 num일 때만 arrList에 추가.
                hashMap.put(num,1);
            }
        }
        Collections.sort(arrList);



        dfs(0,0);
        System.out.println(sb.toString());
    }

    static void dfs(int idx, int depth){
        if(depth == m){
            for(int a : answer){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx; i<arrList.size(); i++){
            Integer num = arrList.get(i);
            if(hashMap.get(num) >= 1){
                answer[depth] = num;
                hashMap.put(num,hashMap.get(num)-1); //사용처리
                dfs(i,depth+1);
                hashMap.put(num,hashMap.get(num)+1); //원복
            }
        }

    }
}
