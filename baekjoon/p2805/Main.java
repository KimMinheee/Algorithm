package baekjoon.p2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static void getMaxLength(){
        int maxIdx = Arrays.stream(arr).max().getAsInt();

        int start = 0;
        int end = maxIdx;
        int candidate = 0;
        while(start<=end){//같을때는 의미가 있다. mid = start+end/2
            int mid = (start+end)/2;
            long sum = 0;
            for(int i=0; i<arr.length;i++){
                long tmp = arr[i] - mid;
                if(tmp>0) sum += tmp;
            }
            if(sum==M){
                System.out.println(mid);
                return;
            }
            else if(sum>M){ //candidate 살려야 한다.
                candidate = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        System.out.println(candidate);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        getMaxLength();
    }
}
