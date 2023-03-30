package programmers.정렬.K번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx=0;

        for(int[] command : commands){
            List<Integer> tmpList = new ArrayList<>();
            for(int i=command[0]-1 ; i<command[1]; i++){
                tmpList.add(array[i]);
            }

            Collections.sort(tmpList);

            answer[idx] = tmpList.get(command[2]-1);
            idx++;
        }

        return answer;
    }
}