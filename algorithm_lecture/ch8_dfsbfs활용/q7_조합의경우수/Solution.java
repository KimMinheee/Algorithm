package algorithm_lecture.ch8_dfsbfs활용.q7_조합의경우수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    public static int dfs(int n, int r){
        if(map[n][r]>0) return map[n][r];
        if(n==r || r==0) return 1;
        return map[n][r] = dfs(n-1,r-1)+dfs(n-1,r);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        System.out.println(dfs(n,r));
    }
}
