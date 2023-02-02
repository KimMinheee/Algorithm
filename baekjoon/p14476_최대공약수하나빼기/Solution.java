package baekjoon.p14476_최대공약수하나빼기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[] nums;
    static int[] ltoR;
    static int[] rtoL;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        ltoR = new int[N];
        rtoL = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ltoR[0] = 0;

        for(int i=1; i<N; i++){
            ltoR[i] = gcd(ltoR[i-1],nums[i]);
        }
        rtoL[N-1] = nums[N-1];
        for(int i=N-2; i>=0; i--){
            rtoL[i] = gcd(rtoL[i+1],nums[i]);
        }

        int max = 0;
        int maxIdx = 0;
        for(int i=0; i<N; i++){
            int tmp = 0;
            //왼쪽 끝
            if(i==0){
                tmp = rtoL[1];
            }
            else if(i==N-1){//오른쪽 끝
                tmp = ltoR[N-2];
            }
            else{
                tmp = gcd(ltoR[i-1],rtoL[i+1]);
            }

            if(nums[i] % tmp !=0 && tmp>max){
               max = tmp;
               maxIdx = i;
            }
        }
        if(max == 0) {
            System.out.println(-1);
        }
        else{
            System.out.println(max + " "+ nums[maxIdx]);
        }
    }
    static int gcd(int a, int b){
        //gcd(a,b) == gcd(b,a%b), a%b==0일때 b에 gcd값이 존재.
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
