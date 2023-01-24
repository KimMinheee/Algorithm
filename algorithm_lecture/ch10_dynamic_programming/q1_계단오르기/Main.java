package algorithm_lecture.ch10_dynamic_programming.q1_계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void solution(int num,int[] dy){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3;i<=num; i++){
            dy[i] = dy[i-1]+dy[i-2];
        }
        System.out.println(dy[num]);

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] dy = new int[num+1];
        solution(num,dy);
    }
}
