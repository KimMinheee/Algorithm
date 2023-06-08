package programmers.구현._1차캐시;

import java.util.*;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;

        if(cacheSize == 0) return cities.length*5;

        List<String> cache = new ArrayList<>(); //cache size만큼 들어가있음.

        for(int i=0; i<cities.length; i++){
            cities[i] = cities[i].toLowerCase(); //소문자로 통일

            if(cache.contains(cities[i])){
                cache.remove(cities[i]);//삭제하고
                cache.add(cities[i]); //맨 뒤로 다시
                totalTime += 1;
            }
            else{
                if(cache.size() == cacheSize){
                    //다 찬 경우
                    cache.remove(0); //맨 앞 삭제
                    cache.add(cities[i]);
                }
                else cache.add(cities[i]);

                totalTime+=5;
            }
        }

        return totalTime;
    }
}
