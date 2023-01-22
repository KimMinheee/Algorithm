package algorithm_lecture.ch6_sorting_and_searching.q2_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static void solution(int[] arr){
        for(int i=arr.length-1; i>0;i--){
            for(int j=0;j<i;j++){
                if(j>=i) break;
                if(arr[j]>arr[j+1]){
                 int temp = arr[j];
                 arr[j] = arr[j+1];
                 arr[j+1] = temp;
                }
            }
        }
        print(arr);
    }

    //버블정렬 최적화 : 큰 분기마다 값이 더이상 정렬되지 않으면 불필요한 반복에서 벗어나 break;
    static void solution2(int[] arr){
        for(int i=arr.length-1;i>0;i--){
            boolean isChange = false;
            for(int j=0;j<i;j++){
                if(j>=i) break;
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isChange = true;
                }
            }
                if(!isChange) break;
        }
        print(arr);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution2(arr);
    }
    static void print(int[] arr){
        for(int a: arr){
            System.out.print(a+" ");
        }
    }
}
