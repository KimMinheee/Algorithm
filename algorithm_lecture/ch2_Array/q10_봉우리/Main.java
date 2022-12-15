package algorithm_lecture.ch2_Array.q10_봉우리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int[][]arr,int num){
        int cnt = 0;
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                int now = arr[i][j];
                if(arr[i][j-1]<now && arr[i][j+1]<now && arr[i-1][j]<now && arr[i+1][j]<now){
                    cnt++;
                }
            }
        }
        return cnt;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num+2][num+2] ; //0으로 초기화된 배열 생성

        //(1,1) ~ (n,n) 데이터 입력
        for(int i=1;i<=num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=num;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(arr,num));
    }
}
