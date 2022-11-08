package algorithm_lecture.ch2_Array.q2_보이는학생;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int[] arr){
        int answer = 0;
        int tmp = 0;
        for(int a : arr){
            if(a>tmp){
                answer++;
                tmp = a;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int arr[] = new int[num];

        String data = br.readLine();
        StringTokenizer st = new StringTokenizer(data);
        for(int i = 0; i<num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }
}
