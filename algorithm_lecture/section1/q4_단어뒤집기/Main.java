package algorithm_lecture.section1.q4_단어뒤집기;
import java.util.Scanner;

//todo : 실행시간 체크

public class Main {
    public static String[] solution(String[] words){
        String data = "";
        
        for(int i=0;i<words.length;i++){
            for(int j=words[i].length();j>0;j--){
                data += words[i].charAt(j-1);
            }
            words[i] = data;
            data = "";
        }
        return words;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.next());
        String[] words = new String[cnt];
        for(int i=0;i<cnt;i++){
            words[i] = sc.next();
        }
        for(String word : solution(words)){
            System.out.println(word);
        }
    }
}
