package algorithm_lecture.section1.q2_대소문자변환;

import java.util.Scanner;

public class Main {
    public static String solution(String word){
        char[] wordList = word.toCharArray();
        int index = 0;
        for(char w : wordList){
            if(Character.isLowerCase(w)){
                wordList[index] = Character.toUpperCase(w);
            }
            else if(Character.isUpperCase(w)){
                wordList[index] = Character.toLowerCase(w);
            }
            index++;
        }
        String result= String.valueOf(wordList);
        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        System.out.println(solution(word));
    }
}
