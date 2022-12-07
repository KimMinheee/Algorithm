package algorithm_lecture.ch3_Twopointers_Slidingwindow.q3_최대매출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int solution(ArrayList arr1, int num1, int num2){


        int max = (Integer) arr1.get(0); //맨 앞 수로 초기화
        int temp = 0;
        for(int i=0; i<num1-num2; i++){
            for(int j=i;j<num2+i;j++){
                temp = temp +(Integer)arr1.get(j);
            }
            max = Math.max(max,temp);
            temp = 0;
        }

        return max;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList arr = new ArrayList<Integer>(num1);
        while(st.hasMoreTokens()){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution(arr,num1,num2));

    }
}