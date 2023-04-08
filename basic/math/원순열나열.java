package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 원순열 : 원형 테이블에 n개의 원소를 나열하는 경우
 * 입력)
 4
 a b c d

 출력)
 a b c d
 a b d c
 a c b d
 a c d b
 a d b c
 a d c b
 */
public class 원순열나열 {
    static int n;
    static char[] data;
    static boolean[] check;
    static char[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        data = new char[n];
        check = new boolean[n];
        answer = new char[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            data[i] =st.nextToken().charAt(0);
        }

        check[0] = true; //맨 앞은 사용처리(고정)
        answer[0] = data[0];
        circlePermutation(1);

        System.out.println(sb.toString());
    }
    static void circlePermutation(int depth){
        if(depth == n){
            for(char c : answer){
                sb.append(c+" ");
            }
            sb.append("\n");

            return;
        }
        for(int i=1; i<n ;i++){
            if(check[i] == false){
                check[i] = true;
                answer[depth] = data[i];
                circlePermutation(depth+1);
                check[i] = false;
            }
        }
    }
}
