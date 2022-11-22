package algorithm_lecture.ch2_Array.q7_점수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int num, ArrayList<Integer> arr){
        int cnt = 0; //반복 개수
        int answer = 0; //결과값

        for(Integer i : arr){
            if(i==1){
                cnt++;
                answer = answer+cnt;
            }
            else{
                cnt = 0; //반복 개수 초기화
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<Integer>();
        String data = br.readLine();
        StringTokenizer st = new StringTokenizer(data);
        for(int i = 0; i<num; i++){
            arr.add(i,Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution(num,arr));
    }
}
