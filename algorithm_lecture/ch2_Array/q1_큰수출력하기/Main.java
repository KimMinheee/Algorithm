package algorithm_lecture.ch2_Array.q1_큰수출력하기;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static String solution(ArrayList<Integer> arr){
        int tmp = Integer.MIN_VALUE;
        String answer = "";

        for(int i = 0;i<arr.size();i++){
            if(arr.get(i)>tmp)
            answer = answer + arr.get(i) + " ";
            tmp = arr.get(i);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<a; i++){
            arr.add(sc.nextInt());
        }
        System.out.println(solution(arr));
    }
}