package algorithm_lecture.ch5_dfsbfs활용.q3_최대점수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> data;
    static int cnt; //총 문제 개수
    static int timeLimit; //제한 시간
    static int max = Integer.MIN_VALUE; //최대 점수

    static void dfs(int idx, int totalScore, int totalTime){
        if(totalTime>timeLimit) return; //제한시간을 넘긴 경우

        if(idx == cnt){
            if(totalScore>max) {
                max = totalScore;
            }
            return;
        }

        int currentScore = data.get(idx).get(0);
        int currentTime = data.get(idx).get(1);

        dfs(idx+1,totalScore+currentScore, totalTime+currentTime);
        dfs(idx+1, totalScore, totalTime);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt = Integer.parseInt(st.nextToken());
        timeLimit = Integer.parseInt(st.nextToken());

        data = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<cnt; i++){
            data.add(new ArrayList<Integer>());
        }

        //데이터 입력
        for(int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            data.get(i).add(0,Integer.parseInt(st.nextToken()));
            data.get(i).add(1,Integer.parseInt(st.nextToken()));
        }

        dfs(0,0,0);
        System.out.println(max);
    }
}
