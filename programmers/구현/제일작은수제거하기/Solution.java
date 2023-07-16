package programmers.구현.제일작은수제거하기;

public class Solution {
    public int[] solution(int[] arr){
        int[] answer;

        //배열에 1개 존재
        if(arr.length <= 1){
            answer = new int[]{-1};
            return answer;
        }

        //배열의 길이가 1보다 클 때
        answer = new int[arr.length - 1]; //가장 작은 수 뺌

        //제일 작은 수 구하기
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }

        //반복
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == min){
                continue;
            }
            answer[idx] = arr[i];
            idx++;
        }

        return answer;
    }
}
