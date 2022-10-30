package algorithm_lecture.section1.q5_특정문자뒤집기;

import java.util.Scanner;

public class Main {
    public static String solution(String word){
        char[] wordList = word.toCharArray();
        int fp = 0; //frontPointer
        int bp = wordList.length-1; //backPointer

        while (fp<bp) {
            if(Character.isAlphabetic(wordList[fp])){
                if(Character.isAlphabetic(wordList[bp])){
                    char temp = wordList[fp];
                    wordList[fp] = wordList[bp];
                    wordList[bp] = temp;
                    fp++;
                    bp--;
                }
                else{
                    bp--;
                }
            }
            else{
                if(Character.isAlphabetic(wordList[bp])){
                    fp++;
                }
                else{
                    fp++;
                    bp--;
                }
            }
        }
        return String.valueOf(wordList); //
    }
    public static String solution2(String word){
        char[] wordList = word.toCharArray();
        int fp = 0; //frontPointer
        int bp = wordList.length-1; //backPointer

        while(fp<bp){
            if(!Character.isAlphabetic(wordList[fp])) fp++;
            else if(!Character.isAlphabetic(wordList[bp])) bp--;
            else{
                char tmp = wordList[fp];
                wordList[fp] = wordList[bp];
                wordList[bp] = tmp;
                fp++;
                bp--;
            }
        }
        return String.valueOf(wordList);

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(solution2(word));
    }
}
