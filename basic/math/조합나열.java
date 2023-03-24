package basic.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [조건]
 * 조합의 경우를 나열
 * 입력) n,r
 *      - n은 데이터의 개수를 의미
 *      - r은 뽑는 데이터의 개수
 * 출력) 나올 수 있는 데이터의 경우를 나열한다.
 *
 * 입력ex)
 * 4 3
 * 1 2 3 4
 *
 * 출력ex)
 * 1 2 3
 * 1 2 4
 * 1 3 4
 * 2 3 4
 */

/**
 * - visited(boolean 배열), n개의 데이터 배열, r개의 결과값 배열(계속 갱신될)
 */

public class 조합나열 {
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

        //조합 구하기
        for(int i=0; i<n; i++){
            answer[0] = data[i];
            combination(i,1); //인덱스, depth
        }
    }


    // 조합
    static void combination(int idx, int depth) {
        if (depth == r) {
            System.out.println(Arrays.toString(answer));
            return;
        }

        for (int i = idx + 1; i < n; i++) {
            visited[i] = true;
            answer[depth] = data[i];
            combination(i, depth + 1);
            visited[i] = true;
        }
    }

}
