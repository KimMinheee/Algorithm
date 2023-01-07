package algorithm_lecture.ch5_dfsbfs활용.q2_바둑이승차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] data;
    static int limit; //태울 수 있는 최대 용량
    static int num; //바둑이 수
    static int max = Integer.MIN_VALUE;

    static void dfs(int idx,int sum){
        if(sum > limit) return; //용량을 초과 한 경우

        if(idx == num){
            if(sum > max) max = sum;
            return;
        }

        dfs(idx+1,sum+data[idx]);
        dfs(idx+1,sum);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());

        data = new int[num];

        //데이터 배열에 저장
        for(int i=0; i<num; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        dfs(0,0);

        System.out.println(max);
    }
}
