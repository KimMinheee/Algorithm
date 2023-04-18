package programmers.해시.전화번호목록;

import java.util.*;

/**
 * 사전순으로 정렬한 후 특정 문자열이 그 다음 문자열 중 시작에 포함하는 경우가 아니라면 특정 문자열의 인덱스를 다음으로 넘긴다.
 * -> 이미 사전순으로 정렬이 되어 있어서 아니라면 더 볼 필요가 없는 것
 * ex) "119" -> "120", "1201" , "1299"..
 */
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);//사전순정렬

        for(int i=0; i<phone_book.length; i++){
            String start = phone_book[i];

            for(int j=i+1;j<phone_book.length; j++){
                if(phone_book[j].startsWith(start)){
                    answer = false;
                    return answer;
                }
                else break;
            }
        }

        return answer;
    }
}