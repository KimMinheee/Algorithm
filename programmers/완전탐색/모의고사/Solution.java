package programmers.완전탐색.모의고사;

/*
1번 - 1,2,3,4,5
2번 - 2,1,2,3,2,4,2,5
3번 - 3,3,1,1,2,2,4,4,5,5
 */

import java.util.*;

class Solution {
    static int[][] students = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};

    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] values = new int[3];

        for(int i=0; i<3; i++){
            int idx = 0;
            int correctCnt = 0;
            while(true){
                if(answers.length == idx) break;
                if(answers[idx] == students[i][idx%students[i].length]) correctCnt++;
                idx++;
            }
            values[i] = correctCnt;
        }

        int max = Arrays.stream(values).max().getAsInt();
        for(int i=0; i<values.length; i++){
            if(values[i] == max) answer.add(i+1);
        }
        //System.out.println(answer.toArray());
        Collections.sort(answer);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}