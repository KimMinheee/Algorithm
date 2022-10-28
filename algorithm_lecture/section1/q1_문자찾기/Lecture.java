package algorithm_lecture.section1.q1_문자찾기;

import java.util.Scanner;

public class Lecture {

    public int solution2(String input,char alpha){
        int cnt = 0;
        input = input.toLowerCase();
        alpha = Character.toLowerCase(alpha);
        for(char w : input.toCharArray()){
            if(w == alpha){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Lecture T = new Lecture();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char alpha = scanner.next().charAt(0);
        int cnt = T.solution2(input,alpha);
        System.out.println(cnt);
    }
}

