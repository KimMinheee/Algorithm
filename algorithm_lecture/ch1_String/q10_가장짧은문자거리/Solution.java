package algorithm_lecture.ch1_String.q10_가장짧은문자거리;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static String solution(String data,char ch){
        int[] answer = new int[data.length()];
        String tmp="";
        int p = 1000; //문제에 주어진 100보다 훨씬 높은 수를 초기값으로 지정.

        for (int i=0; i<data.length(); i++){
            if(data.charAt(i)==ch){
                p=0;
                answer[i] = p;
            }
            else{
                p++;
                answer[i] = p; //왼->오 먼저니까 일단 초기화(나중에 비교할 값이 필요)
            }
        }
        p=1000;
        for(int i=data.length()-1; i>=0; i--){
            if(data.charAt(i)==ch) p=0;
            else{
                p++;
                answer[i] = Math.min(p,answer[i]);
            }
        }
        for (int i : answer){
            tmp+=i;
        }
        return tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String data = st.nextToken();
        char ch = st.nextToken().charAt(0);

        bw.write(solution(data,ch));
        bw.flush();

    }
}
