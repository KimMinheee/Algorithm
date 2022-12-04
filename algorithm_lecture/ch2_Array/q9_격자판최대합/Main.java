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

    //코드 개선
    public static int solution2(int num, int[][]arr){
        int answer = Integer.MIN_VALUE; //정수 중 가장 작은 값으로 초기화
        int sum1, sum2;

        //행, 열
        for(int i=0;i<num;i++){
            sum1 = sum2 =0;
            for(int j=0;j<num;j++){
                sum1 = sum1 + arr[i][j]; //열의 합
                sum2 = sum2 + arr[j][i]; //행의 합
            }
            answer = Math.max(answer,sum1);
            answer = Math.max(answer,sum2);
        }
        sum1 = sum2 = 0;
        //대각선
        for(int i=0;i<num;i++){
                sum1 = sum1 + arr[i][i];
                sum2 = sum2+ arr[num-1-i][i];
        }
        answer = Math.max(answer,sum1);
        answer = Math.max(answer,sum2);

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

        System.out.println(solution2(num,arr));
    }

}
