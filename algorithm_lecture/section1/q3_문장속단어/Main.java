package algorithm_lecture.section1.q3_문장속단어;
import java.util.Scanner;

public class Main {
    public static String solution(String data){
        String[] strList = data.split(" ");
        int index = 0;
        int count = strList[0].length();
        for(int i=0;i<strList.length;i++){
            if(strList[i].length()>count){
                index = i;
                count = strList[i].length();
            }
        }
        return strList[index];
    }

    public static String solution2(String data){
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while((pos = data.indexOf(' ')) != -1){
            String tmp = data.substring(0,pos); //0번째인덱스 ~ (pos-1)번째 인덱스까지 자르기

            int len = tmp.length();
            if(len>m){
                m = len;
                answer = tmp;
            }
            data = data.substring(pos+1); //문자열 다시 갱신
        }
        if(data.length()>m){
            answer = data;
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();

        System.out.println(Integer.MIN_VALUE);

        System.out.println(solution2(data));
    }
}
