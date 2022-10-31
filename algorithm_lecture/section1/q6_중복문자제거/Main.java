package algorithm_lecture.section1.q6_중복문자제거;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String solution(String data) {
        char[] list = data.toCharArray();
        ArrayList<Character> answer = new ArrayList<Character>();
        for (int i = 0; i < list.length; i++) {
            if(i==0){
                answer.add(list[0]);
            }
            else{
                   if(!answer.contains(list[i])){
                       answer.add(list[i]);
                   }
                   else{
                       continue;
                   }
            }
        }
        String result = "";
        for(Character str : answer){
            result+=str;
        }
        return result;
    }

    public static void main (String[]args){

        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        System.out.println(solution(data));
    }

    }