package programmers.구현._3차_압축;

import java.util.*;

class Solution {
    public int[] solution(String msg) {

        Map<String,Integer> hashMap = new HashMap<String,Integer>();
        int lastIndex = 1;
        for(int i=0; i<'Z'-'A'+1; i++){
            hashMap.put(String.valueOf((char)('A'+i)),i+1);
            lastIndex++;
        }


        List<Integer> result = new LinkedList<>();
        boolean isFinish = false; //끝까지 탐색했는지 확인

        for(int a=0; a<msg.length(); a++){
            if(isFinish) break;

            int index = 0;
            String substr = "";
            for(int b=a+1; b<= msg.length(); b++){
                substr = msg.substring(a,b);
                if(hashMap.containsKey(substr)){
                    index = hashMap.get(substr);
                    if(b == msg.length()){
                        isFinish = true;
                    }
                    continue;
                }
                else{
                    a=b-2;
                    break;
                }
            }
            hashMap.put(substr,lastIndex++);
            result.add(index);
        }

        //linkedList to int[]
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;

    }
}
