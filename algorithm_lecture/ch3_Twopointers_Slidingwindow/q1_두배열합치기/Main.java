package algorithm_lecture.ch3_Twopointers_Slidingwindow.q1_두배열합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static String solution(ArrayList arr1, ArrayList arr2){
        String answer ="";
        arr1.addAll(arr2);
        Collections.sort(arr1);
        for(Object c : arr1){
            answer = answer + c.toString()+" ";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList arr1 = new ArrayList<>(num1);
        while(st.hasMoreTokens()){
            arr1.add(Integer.parseInt(st.nextToken()));
        }

        int num2 = Integer.parseInt(br.readLine());
        st =new StringTokenizer(br.readLine());
        ArrayList arr2 = new ArrayList<>(num2);
        while(st.hasMoreTokens()){
            arr2.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution(arr1,arr2));

    }
}
