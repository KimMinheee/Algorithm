package algorithm_lecture.ch2_Array.q8_등수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static String solution(int num, ArrayList<Integer> arr){
        String answer = "";
        ArrayList<Integer> temp = (ArrayList<Integer>)arr.clone();

        Collections.sort(arr, Collections.reverseOrder()); //내림차순으로 정렬

        int rank = 1; //순위
        //int[] tempRank = new int[num]; //순위 저장하는 int 배열
        ArrayList<Integer> tempRank = new ArrayList<>(num);
        int before = -1;// 이전 값
        int repeatCnt = 0; //반복 횟수

        //정렬 된 상태에서 순서 구하기
        for(int i=0; i<num; i++){
            if(arr.get(i) == before){
                repeatCnt++; //반복 횟수 +1
                tempRank.add(rank);
            }
            else{ //앞>뒤인 경우
                rank = rank + repeatCnt;
                tempRank.add(rank);
                repeatCnt =1;//0으로 초기화
            }
            before = arr.get(i);
        }


        //원래 데이터(정렬x)에서 순서 구하기
        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                if(temp.get(i) == arr.get(j)){
                    answer = answer + String.valueOf(tempRank.get(j)) + " ";
                    break;
                }
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