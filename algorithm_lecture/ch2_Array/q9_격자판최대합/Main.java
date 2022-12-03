package algorithm_lecture.ch2_Array.q9_격자판최대합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int num,int[][] arr){
        int answer =0;
        int temp =0;

        //오->왼 대각선의 합
        for(int i=0; i<num; i++){
            temp = temp + arr[i][i];
            answer = temp;
        }
        temp = 0; //초기화

        //왼->오 대각선의 합
        for(int i=0;i<num;i++){
            temp = temp + arr[num-1-i][i];
        }
        if(answer<temp) answer = temp;
        temp = 0; //초기화

        //열의 합
        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                temp = temp+arr[j][i];
            }
            if(answer<temp) answer = temp;
            temp=0;
        }
        temp = 0; //초기화

        //행의 합
        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                temp = temp+arr[i][j];
            }
            if(answer<temp) answer = temp;
            temp =0;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][num];

        for(int i=0; i<num; i++){
            String data = br.readLine();
            StringTokenizer st = new StringTokenizer(data);
            for(int j = 0; j<num; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(num,arr));
    }

}
