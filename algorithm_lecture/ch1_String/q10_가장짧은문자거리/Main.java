package algorithm_lecture.ch1_String.q10_가장짧은문자거리;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static String solution(String data,char ch){
        char[] arr = data.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        String answer = "";

        for(int i = 0; i <arr.length; i++){
            if(arr[i]==ch) list.add(0);
            else{
                int leftCnt = 0;
                int rightCnt = 0;
                boolean leftexist = false;
                boolean rightexist = false;

                for(int j=i-1;(j>=0&&j<i);j--){ //i 이전에 있는지 탐색.
                    leftCnt++;
                    if(arr[j]==ch){
                        leftexist = true;
                        break;
                    }
                }
                for(int j=i+1;(j<arr.length&&j>i);j++){ //i 이후에 있는지 탐색
                    rightCnt++;
                    if(arr[j]==ch){
                        rightexist = true;
                        break;
                    }
                }
                //좌,우 차이값 비교
                if(!rightexist){
                    if(leftexist){ //왼쪽만 존재
                        list.add(leftCnt);
                    }
                }
                else{
                    if(leftexist){ //둘다 존재
                        if(leftCnt<rightCnt) list.add(leftCnt);
                        else list.add(rightCnt);
                    }
                    else{//오른쪽만 존재
                        list.add(rightCnt);
                    }
                }

            }
        }

        //출력 형식 맞추기
        for(Integer i : list){
            answer += i;
            answer +=" ";
        }

        return answer ;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String data = st.nextToken();
        char c = st.nextToken().charAt(0);

        bw.write(solution(data,c));

        bw.flush();

    }
}
