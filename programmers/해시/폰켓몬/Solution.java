package programmers.해시.폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        boolean[] check = new boolean[200001];
        int answer = 0;

        //hashMap에 데이터 세팅
        HashMap<Integer,Integer> hashMap = new HashMap<>(200001);

        for(int n : nums){
            if(hashMap.containsKey(n)){
                hashMap.put(n,hashMap.get(n)+1);
            }
            else hashMap.put(n,1);
        }

        //nums.size/2 만큼 가져가는 경우가 가장 베스트.
        for(Integer key : hashMap.keySet()){
            if(answer >= nums.length/2) return answer;

            if(hashMap.get(key)>=1 && check[key]==false){
                answer++;
                check[key] = true;
                hashMap.put(key,hashMap.get(key)-1);
            }
        }

        return answer;
    }
}