package programmers.슬라이딩윈도우.할인행사;

/**
 - 프로그래머스 - 할인 행사
 - 슬라이딩 윈도우 사용 (처음 세팅 후 -> 윈도우 밀기)
 */

import java.util.*;

class Solution {
    static Map<String, Integer> wantMap = new HashMap<>(); //String과 index를 저장
    static int[] tmpArr;
    static int wantSize;
    static int answer = 0;

    public int solution(String[] want, int[] number, String[] discount) {
        wantSize = want.length;
        tmpArr = new int[wantSize];

        for(int i=0; i<want.length; i++){
            wantMap.putIfAbsent(want[i],i);
        }

        //처음 슬라이딩 윈도우 0-9 세팅
        for(int i=0; i<10; i++){
            if(wantMap.containsKey(discount[i])){
                int idx = wantMap.get(discount[i]);
                tmpArr[idx] = tmpArr[idx]+1;
            }
        }
        checkRegistrationPossible(number); //처음 10개에 대한 등록 여부 확

        int startIdx = 0;
        int endIdx = 9;

        while(endIdx < discount.length - 1){
            slideWindow(startIdx, endIdx, discount);
            checkRegistrationPossible(number);

            startIdx++;
            endIdx++;
        }

        return answer;
    }


    void slideWindow(int startIdx, int endIdx, String[] discount){
        //앞에꺼 빼기
        String key = discount[startIdx];
        if(wantMap.containsKey(key)){
            tmpArr[wantMap.get(key)] -= 1;
        }

        //뒤에꺼 추가
        String newKey = discount[endIdx+1];
        if(wantMap.containsKey(newKey)){
            tmpArr[wantMap.get(newKey)] += 1;
        }
    }

    void checkRegistrationPossible(int[] number){
        boolean isPossible = true;
        for(int i=0; i<wantSize; i++){
            if(tmpArr[i] != number[i]){
                isPossible = false;
                break;
            }
        }
        if(isPossible) answer++;
    }
}