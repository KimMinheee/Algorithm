package programmers.구현.다음큰숫자;

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int nextNumber = n+1;
        int countOfOne = getOneCount(Integer.toString(n,2));

        while(n < 1000000){
            String nextBinaryNum = Integer.toString(nextNumber,2);

            int nextCountOfOne = getOneCount(nextBinaryNum);

            if(nextCountOfOne == countOfOne){
                answer = nextNumber;
                break;
            }

            ++nextNumber;
        }

        return answer;
    }
    private int getOneCount(String data){
        char[] dataArr = data.toCharArray();
        int count = 0;

        for(int i=0; i<dataArr.length; i++){
            if(dataArr[i] == '1'){
                count++;
            }
        }

        return count;
    }
}
