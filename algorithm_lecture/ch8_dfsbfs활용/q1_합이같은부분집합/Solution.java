package algorithm_lecture.ch8_dfsbfs활용.q1_합이같은부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] data; //집합의 원소 배열 - n개
    static int[] ch; //
    static int num;
    static int total = 0;
    static boolean flag;
    static String text = "NO";

    public static void dfs(int a, int sum){
        if(flag) return; //이미 찾음.
        if(sum>total/2) return; //들어온 sum의 값이 이미 토탈의 절반 이상인 경우.

        if(a == num){
            if(sum==total/2){
                text = "YES";
                flag = true;
            }
            return;
        }

        dfs(a+1,sum+data[a]); //해당 값 포함 o
        dfs(a+1, sum); //해당 값 포함 x
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        ch = new int[num];
        data = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++){
            data[i] = Integer.parseInt(st.nextToken());
            total+=data[i];
        }

        dfs(0,0);
        System.out.println(text);
    }
}
