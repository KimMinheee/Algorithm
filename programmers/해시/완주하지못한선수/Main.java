package programmers.해시.완주하지못한선수;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<>();

        for(String s : participant){
            if(participantMap.containsKey(s)){
                participantMap.put(s, participantMap.get(s)+1);
            }
            else participantMap.put(s,1);
        }

        for(String key :completion){
            if(participantMap.containsKey(key)){
                participantMap.put(key,participantMap.get(key)-1);
            }
        }

        for(String key: participantMap.keySet()){
            if(participantMap.get(key) ==1) return key;
        }

        return "";

    }
}