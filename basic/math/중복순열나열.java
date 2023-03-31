package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 중복순열나열 {
    static int n,r;
    static int[] data;
    // static boolean[] visited; -> 중복순열에서는 같은 값을 가져도 됨으로 방문처리를 할 필요가 없다.
    static int[] answer;
    static int cnt = 0; //개수 확인하려고 만든 변수.

    public static void main(String[ ]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());


        data = new int[n];
        answer = new int[r];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        duplicatePermutation(0);
        System.out.println(cnt);
    }

    static void duplicatePermutation(int depth){
        if(depth == r){
            System.out.println(Arrays.toString(answer));
            cnt++;
            return;
        }

        for(int i=0; i<n; i++){
            answer[depth] = data[i];
            duplicatePermutation(depth+1);
        }
    }

}
