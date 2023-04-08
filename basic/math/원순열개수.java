package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 원순열 : 원모양의 테이블에 n개의 원소를 앉히는 경우의 수
 * 원순열의 개수 : (n-1)!
 * - 한 명 고정시켜놓고 나머지 돌린다(순열)고 생각하면 된다.
 */
public class 원순열개수 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(getCirclePermutationCnt(n-1));
    }
    static int getCirclePermutationCnt(int n){
        if(n<=1) return 1;
        return n*getCirclePermutationCnt(n-1);
    }
}
