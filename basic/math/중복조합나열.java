package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 중복조합나열 {
    static int n,r;
    static int[] data;
    static boolean[] visited;
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

        for(int i=0; i<n; i++){
            answer[0] = data[i];
            duplicateCombination(i,1);
        }
        System.out.println(cnt);//개수 출력
    }

    static void duplicateCombination(int idx, int depth){
        if (depth == r) {
            System.out.println(Arrays.toString(answer));
            return;
        }
        for(int i = idx; i<n; i++){ //그냥 조합과의 차이는 i가 idx부터 시작하는 것.
            cnt++;
            answer[depth] = data[i];
            duplicateCombination(i, depth+1);
        }
    }

}
