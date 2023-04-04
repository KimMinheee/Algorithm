package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 같은 것이 있는 순열 나열:
 * 개수와 데이터가 주어질 때 같은 것이 있는 순열을 나열해보자.
 * 입력)
 4
 a a b b
 *
 * 출력)
 a a b b
 a b a b
 a b b a
 b a a b
 b a b a
 b b a a

 풀이 : dfs + 백트래킹
 - 값을 입력 받으면 hashMap에 값을 키로 사용하고 중복횟수를 value로 사용한다.
 - 각 데이터의 횟수를 기준으로 작성
 - dfs
    : hashMap의 keyset을 for문으로 돈다.
    - hashMap의 key에 해당하는 value값이 1이상이면, 즉 사용할 수 있으면 사용처리(value-1) 후 dfs를 다시 돈다.
    - depth가 N에 다다르면 route값을 StringBuilder에 add하고 return 한다.
    - 이때 dfs를 다 돌고 끝났다면 다음 라인에서 사용했던 key값을 백트래킹한다.(value+1)
 */
public class 같은것이있는순열나열 {
    static int n ; //데이터의 개수
    static HashMap<Character,Integer> hashMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            char c  = st.nextToken().charAt(0);
            if(hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c)+1);
            }
            else{
                hashMap.put(c,1);
            }
        }

        //테스트 출력용
        for(Map.Entry<Character,Integer> map : hashMap.entrySet()){
            System.out.println(map.getKey()+" : "+map.getValue());
        }

        dfs("",0);

        System.out.println(sb.toString());

    }

    static void dfs(String route, int depth){
        if(depth == n){
            sb.append(route+"\n");
            return;
        }
        for(Character key : hashMap.keySet()){
            int value = hashMap.get(key);
            if(value >=1 ){
                hashMap.put(key,value-1); //사용
                dfs(route+" "+key,depth+1);
                hashMap.put(key,hashMap.get(key)+1); //백트래킹(원복)
            }
        }
    }

}
