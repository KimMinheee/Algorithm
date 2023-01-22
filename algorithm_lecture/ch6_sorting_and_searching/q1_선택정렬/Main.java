package algorithm_lecture.ch6_sorting_and_searching.q1_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static void solution(int[] arr){
        int min,minIdx;

        for(int i=0; i<arr.length-1;i++){
            min = arr[i+1];
            minIdx = i+1;
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];
                    minIdx = j;
                }
            }
            if(arr[i]>min){
                int temp = arr[i];
                arr[i] = min;
                arr[minIdx] = temp;
            }
        }

        print(arr);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(arr);
    }
    static void print(int[] arr){
        for(int a : arr){
            System.out.print(a+" ");
        }
    }
}
