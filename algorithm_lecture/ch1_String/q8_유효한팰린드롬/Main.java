package algorithm_lecture.ch1_String.q8_유효한팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static String solution(String data){
        char[] list = data.toCharArray();
        ArrayList<Character> alphaList = new ArrayList<>();

        // 알파벳인 글자만 소문자화하여 alphaList에 add.
        for(char word : list){
            if(Character.isAlphabetic(word)){
                alphaList.add(Character.toLowerCase(word));
            }
        }
        //팰린드롬 여부 확인
        int fp = 0, bp = alphaList.size()-1;
        while(fp<bp){
            if(alphaList.get(fp)!=alphaList.get(bp)){
                return "NO";
            }
            fp++;
            bp--;
        }
        return "YES";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        System.out.println(solution(data));
    }
}
