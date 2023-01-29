package algorithm_lecture.ch10_dynamic_programming.q2_돌다리건너기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void solution(int num,int[] dy){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3;i<=num+1; i++){
            dy[i] = dy[i-1]+dy[i-2];
        }
        System.out.println(dy[num+1]);

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] dy = new int[num+2];
        solution(num,dy);
    }
}
