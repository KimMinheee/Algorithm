package algorithm_lecture.ch1_String.q1_문자찾기;
import java.util.Scanner;

class Main{
    public int solution(String input, String alpha){
        int cnt = 0;
        input = input.toLowerCase();
        alpha = alpha.toLowerCase();
        for(int i=0;i<input.length();i++){
            if(String.valueOf(input.charAt(i)).equals(alpha)){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Main T = new Main();

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String alpha = scanner.nextLine();
        int cnt = T.solution(input,alpha);
        System.out.println(cnt);
    }
}