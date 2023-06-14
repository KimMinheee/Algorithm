package programmers.해시.의상;

import java.util.*;

class Solution {
    static Map<String, List<String>> map = new HashMap<>();
    public int solution(String[][] clothes) {

        for(String[] cloth : clothes){
            if(map.containsKey(cloth[1])){
                List<String> tmpList = map.get(cloth[1]);
                tmpList.add(cloth[0]);
                map.replace(cloth[1],tmpList);
            }
            else{
                List<String> tmpList = new ArrayList<>();
                tmpList.add(cloth[0]);
                map.put(cloth[1],tmpList);
            }
        }

        int answer = 1;
        //경우의 수 계산
        for(String key : map.keySet()){
            int count = map.get(key).size()+1;
            answer = count * answer;
        }
        //둘 다 안입게 되는 경우(문제조건 벗어남) 제외
        return answer-1;

    }
}