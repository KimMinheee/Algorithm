package programmers.스택_큐.같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answerList = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        int tmp = arr[0];
        answerList.add(tmp);


        for(int i=1; i<arr.length; i++){
            if(tmp != arr[i]){
                answerList.add(arr[i]);
                tmp = arr[i];
            }
        }

        int[] answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}