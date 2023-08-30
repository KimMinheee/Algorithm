package programmers.구현.영어끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int peopleCount = 0;
        int gameCount = 1;
        String prev = "";
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            String now = words[i];
            peopleCount++;

            if(i != 0){
                char nowChar = now.charAt(0);
                char prevChar = prev.charAt(prev.length()-1);
                if(prevChar != nowChar || map.containsKey(now)){
                    answer[0] = peopleCount;
                    answer[1] = gameCount;
                    break;
                }
            }

            map.put(now, 0);
            prev = now;

            if(peopleCount == n){
                peopleCount = 0;
                gameCount ++;
            }
        }

        return answer;
    }
}
