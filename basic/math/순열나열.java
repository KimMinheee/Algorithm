package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [조건]
 * 순열의 경우를 나열
 * 입력) n,r
 *      - n은 데이터의 개수를 의미
 *      - r은 뽑는 데이터의 개수
 * 출력) 나올 수 있는 데이터의 경우를 나열한다.
 *
 * 입력ex)
 * 4 3
 * 11 12 13 14
 *
 * 출력ex)
 * 1 2 3
 * 1 2 4
 * 1 3 4
 * 2 3 4
 */

/**
 * - visited(boolean 배열), n+1개의 데이터 배열, r+1개의 결과값 배열(계속 갱신될)
 */

public class 순열나열 {
    static int n,r;
    static int[] data;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());


        data = new int[n];
        visited = new boolean[n];
        answer = new int[r];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);
    }

    //basic 코드
    static void permutation(int depth){
        if(depth == r){
            System.out.println(Arrays.toString(answer));
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                visited[i] = true;
                answer[depth] = data[i];
                permutation(depth+1);
                visited[i] = false;
            }
        }
    }


}
