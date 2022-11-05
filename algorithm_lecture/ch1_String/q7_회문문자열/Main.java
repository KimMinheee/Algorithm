package algorithm_lecture.ch1_String.q7_회문문자열;

import java.util.Scanner;

public class Main {
    public static String solution(String word){

        char[] list = word.toLowerCase().toCharArray();
        int fp = 0, bp = list.length-1;
        while(fp<bp){
            if(list[fp]!=list[bp]){
                return "NO";
            }
            fp++;
            bp--;
        }
        return "YES";
    }

    public static String solution2(String word){
        String answer = "NO";
        String tmp = new StringBuilder(word).reverse().toString();
        if(tmp.equalsIgnoreCase(word)) answer = "YES";

        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(solution2(word));
    }
}
