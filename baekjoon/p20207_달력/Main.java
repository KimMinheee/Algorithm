package baekjoon.p20207_달력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [구현] 20207_달력
 * 아이디어 :
 * - calc Class(일정있는지,없는지 int 변수, 세로길이)
 * - ArrayList (범위 0~365)
 */
public class Main {
    static List<Calc> schedules = new ArrayList<>(366); //맨앞 0 ,맨뒤 1여유공간
    static int max = Integer.MIN_VALUE; //366까지 돌지 않기 위해

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //일정 개수

        for(int i=0; i<=365; i++){
            schedules.add(new Calc(0,0));
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            max = Math.max(max,finish);

            markCalendar(start, finish);
        }
        System.out.println(getSize());
    }
    static void markCalendar(int start, int finish){
        //1. 리스트의 start와 finish가 0인지 확인
        //1.1 0이라면 1로 바꾸고 depth도 +1
        //1.2 중간에 1이 껴있다면 1로 바꾸고 depth+1
        for(int i=start; i<=finish; i++){
            schedules.get(i).check = 1;
            schedules.get(i).depth++;
        }
    }
    static int getSize(){
        //2. max값 이전까지만 돌면서 maxDepth * 인덱스개수로 사각형 넓이 구한다
        int width = 0;
        int maxDepth = 0;
        int answer=0;
        for(int i=1; i<=max; i++){
            if(schedules.get(i).check ==1){
                width++;
                maxDepth = Math.max(maxDepth,schedules.get(i).depth);
                if(i == max){
                    answer += width * maxDepth;
                    width = 0; //초기화
                    maxDepth = 0;
                }
            }
            else if(schedules.get(i).check == 0 ){ //중간에 일정 끊긴 경우
                answer += width * maxDepth;
                width = 0; //초기화
                maxDepth = 0;
            }
        }
        return answer;
    }
}
class Calc{
    int check;
    int depth;

    public Calc(int check, int depth) {
        this.check = check;
        this.depth = depth;
    }
}
