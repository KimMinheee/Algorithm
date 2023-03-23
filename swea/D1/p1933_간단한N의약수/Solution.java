package swea.D1.p1933_간단한N의약수;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        //13이하의 약수. 배열을 14개 만들고  1부터 나눔. 중간까지 나누면 끝내고 1로 바뀐거 출력한다.

        checkDivisors(); //약수 체크
        printDivisors(); //약수 출력
        br.close();
    }
    static void checkDivisors(){
        for(int i=1; i<=N/2; i++){
            if(N % i == 0){
                arr[i] = 1;
                arr[N/i] = 1;
            }
        }
    }
    static void printDivisors(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(arr[i] == 1) sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}
