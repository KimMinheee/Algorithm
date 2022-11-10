package algorithm_lecture.ch2_Array.q3_가위바위보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static String[] solution(int[] a, int[] b, int num){
        String[] answer = new String[num];
        for(int i  = 0; i<num; i++){
            if(a[i] == b[i]) answer[i]="D";
            else if(a[i]>b[i]){

                if(a[i]==3 && b[i]==1) {
                    answer[i]= "B";
                    continue;
                }
                answer[i]= "A";
            }
            else {
                if(a[i]==1 && b[i]==3){
                    answer[i]= "A";
                    continue;
                }
                answer[i]= "B";
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int a[] = new int[num];
        int b[] = new int[num];

        String data = br.readLine();
        StringTokenizer st = new StringTokenizer(data);
        for(int i = 0; i<num; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        data = br.readLine();
        st = new StringTokenizer(data);
        for(int i = 0; i<num; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }


        for(String s : solution(a,b,num)){
            System.out.println(s);
        }
    }
}
