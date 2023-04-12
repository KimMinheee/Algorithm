package programmers.그리디.큰수만들기;

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int num = number.length() - k;
        int[] numberArr = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();


        //배열
        int maxValue = Integer.MIN_VALUE;
        int maxIdx = -1;
        int startIdx = 0;

        for(int i=0; i<num; i++){ //0 ~ 3 - 0,1,2,3
            maxValue = Integer.MIN_VALUE;
            maxIdx = -1;

            int[] tmp = Arrays.copyOfRange(numberArr,startIdx,number.length()-(num-i)+1);
            for(int j=0; j<tmp.length; j++){
                if(tmp[j] > maxValue){
                    maxIdx = j+startIdx;
                    maxValue = tmp[j];
                }
            }
            startIdx = maxIdx+1;
            sb.append(maxValue);
        }

        //System.out.println(sb.toString());
        return sb.toString();
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.solution("4177252841",4);
    }
}