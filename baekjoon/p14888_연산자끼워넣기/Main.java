package baekjoon.p14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * p14888_연산자끼워넣기
 * : 같은 것이 있는 순열
 */
public class Main {
    static int minValue  = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;
    static int[] data;
    static int[] operator;
    static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        data = new int[n];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            data[i] = num;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            int op = Integer.parseInt(st.nextToken());
            operator[i] = op;
        }

        dfs(0,0,data[0]);
        System.out.println(maxValue+"\n"+minValue);

    }
    static void dfs(int dataIdx, int depth, int total){

        if(depth == n-1) {
            minValue = Math.min(minValue, total);
            maxValue = Math.max(maxValue, total);
            return;
        }
        for(int i=0; i<4; i++){
            if(operator[i] >= 1){
                int num;
                if(i == 0) num = total+ data[dataIdx+1];
                else if( i== 1) num = total - data[dataIdx+1];
                else if(i == 2) num = total * data[dataIdx+1];
                else num = total / data[dataIdx+1];

                operator[i] -= 1;
                dfs(dataIdx+1,depth+1,num);
                operator[i] += 1;
            }
        }
    }
}
