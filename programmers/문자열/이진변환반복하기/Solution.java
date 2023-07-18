package programmers.문자열.이진변환반복하기;

import java.util.*;

/**
 1. s를 charAt으로 돌면서 StringBuilder에서 0이 아닌 값만 더함.
 2. 해당 StringBuilder의 사이즈를 구함.
 3. 사이즈를 Integer.toString() 메소드를 이용해 이진법으로 변환
 - 위 과정을 반복하면서 제거하는 0의 개수와 이진변환 횟수를 구한다.
 */

class Solution {
    static int zeroCount = 0;
    static int repeatCount = 0;

    public int[] solution(String s) {
        binaryDfs(s);

        int[] answer = new int[]{repeatCount, zeroCount};
        return answer;
    }

    public String binaryDfs(String data){
        repeatCount++; //반복횟수 1 추가

        //1. 0 제거
        StringBuilder sb = new StringBuilder();
        for(char c : data.toCharArray()){
            if(c == '0'){
                zeroCount++; //0 제거횟수 추가
                continue;
            }
            sb.append(c);
        }

        //2. sb의 길이 구하기
        int size = sb.length();

        //3. 2진법 표현한 문자열
        String binaryResult = Integer.toString(size,2);

        if(binaryResult.equals("1")) return binaryResult;
        return binaryDfs(binaryResult);
    }
}
