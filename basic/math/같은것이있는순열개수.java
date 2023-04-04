package basic.math;

import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 같은 것이 있는 순열 개수:
 * 개수와 값 주어질 때 같은 것이 있는 순열의 개수를 구해보자.
 * 입력)
 5
 1 2 2 3 3
 *
 * 출력)
 30
 */
public class 같은것이있는순열개수 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer,Integer> hashMap = new HashMap<>(); //개수 저장하기 위해
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }
            else{
                hashMap.put(num,1);
            }
        }
        int answer = factorial(n);
        for(Integer key : hashMap.keySet()){
            if(hashMap.get(key) > 1) answer = answer / factorial(hashMap.get(key));
        }
        System.out.println(answer);
    }
    static int factorial(int n){
        if(n<=1) return 1;
        return n *  factorial(n-1);
    }
}
