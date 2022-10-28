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

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();

        System.out.println(solution(data));
    }
}
