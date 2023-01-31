package baekjoon.p2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//todo : getCnt()에서 왜 while조건이 left<=right이면 오류인지?
public class Main {
    static int N,M;
    static int[] arr;

    static void getCnt(){
        int leftIdx = 0;
        int rightIdx = 0;
        int cnt = 0;

        while(leftIdx<N && rightIdx<N && leftIdx>=0 && rightIdx>=0){
            int sum = 0;
            for(int i=leftIdx; i<=rightIdx; i++){
                sum = sum + arr[i];
            }
            if(sum == M){
                cnt++;
                rightIdx++;
            }
            else if(sum<M){
                rightIdx++;
            }
            else{
                leftIdx++;
            }
        }
        System.out.println(cnt);
    }
    static void getCnt2(){
        int leftIdx = 0;
        int rightIdx = 0;
        int cnt = 0;
        int sum = 0;

        sum = arr[0];

        while(true){
            for(int i=leftIdx; i<=rightIdx; i++){
                sum = sum + arr[i];
            }
            if(sum == M){
                cnt++;
                sum -= arr[leftIdx++];
            }
            else if(sum<M){
                sum+= arr[++rightIdx];
            }
            else{
                sum -= arr[leftIdx++];
            }
            if(rightIdx == N){
                break;
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1]; //인덱스 넘치는거 방지

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        getCnt();
    }
}
