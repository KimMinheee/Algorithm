package algorithm_lecture.section1.q7_회문문자열;

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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(solution(word));
    }
}
