package baekjoon.p2961_도영이가만든맛있는음식;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] sourValues; //신맛
    static int[] bitterValues; //쓴맛
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sourValues = new int[N];
        bitterValues = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            sourValues[i] = sour;
            bitterValues[i] = bitter;
        }

        findMinDiff(0,1,0);
        System.out.println(answer);
        br.close();
    }
    static void findMinDiff(int index, int totalSour, int totalBitter){
        if(index >= N) return;

        //신맛과 쓴맛의 차이가 가장 적은 요리의 차이를 출력한다.
        for(int i=index; i<N; i++){
            int tmpTotalSour = totalSour * sourValues[i];
            int tmpTotalBitter = totalBitter + bitterValues[i];
            answer = Math.min(answer, Math.abs(tmpTotalSour - tmpTotalBitter));
            findMinDiff(i+1,tmpTotalSour,tmpTotalBitter);
        }
    }
}
