package algorithm_lecture.ch2_Array.q8_등수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static String solution(int num, ArrayList<Integer> arr){
        String answer = "";
        Collections.sort(arr, Collections.reverseOrder()); //내림차순으로 정렬
        int cnt = 1; //순위
        answer += String.valueOf(cnt);
        System.out.println(arr);

        //결과값(순위) 산출
        for(int i = 1; i<num; i++){
            if(arr.get(i) == arr.get(i-1)){
                answer += String.valueOf(cnt);
                continue;
            }
            cnt ++;
            answer += String.valueOf(cnt);
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
