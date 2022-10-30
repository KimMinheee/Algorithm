package algorithm_lecture.section1.q2_대소문자변환;

import java.util.Scanner;

public class Lecture {
    public static String solution(String word){
        String answer = "";
        for(char w : word.toCharArray()){
            if(Character.isLowerCase(w)){
                answer += Character.toUpperCase(w);
            }
            else {
               answer += Character.toLowerCase(w);
            }
        }
        return answer;
    }

    public static String solution2(String word){
        String answer = "";
        char[] wordList = word.toCharArray();
        for (char w : wordList){
            if(w>=65 && w<=90) answer += (char)w+32; //소문자 -> 대문자
            else if(w>=97 && w<122) answer += (char)w-32; //대문자 -> 소문자
        }
        return answer;
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        System.out.println(solution(word));
    }
}