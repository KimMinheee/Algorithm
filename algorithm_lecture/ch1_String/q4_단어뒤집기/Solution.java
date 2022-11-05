package algorithm_lecture.ch1_String.q4_단어뒤집기;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    //sol1: StringBuilder() 클래스 이용한 풀이
    public static ArrayList<String> solution(int cnt, String[] words){
        ArrayList<String> answer = new ArrayList<>();

        for(String x : words){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    //sol2 : 직접 코드 짜기(for-while)
    public static ArrayList<String> solution2(int cnt, String[] words){
        ArrayList<String> answer = new ArrayList<>();

        for(String w : words){
            char[] arr = w.toCharArray();
            int fp = 0, bp = w.length()-1;
            while(fp<bp){
                char tmp = arr[fp];
                arr[fp] = arr[bp];
                arr[bp] =  tmp;
                fp++;
                bp--;
            }
            answer.add(String.valueOf(arr));
        }
        return answer;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String[] words = new String[cnt];
        for(int i=0;i<cnt;i++){
            words[i] = sc.next();
        }
        for(String word : solution2(cnt,words)){
            System.out.println(word);
        }
    }
}
