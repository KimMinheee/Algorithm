package programmers.완전탐색.카펫;

import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int y=1;y<=yellow;y++){
            if(yellow % y == 0){
                int width = yellow/y; //가로
                int height = y; //세로

                if(height > width) break;

                int brownCount = (width*2) + (height+2)*2;
                if(brown == brownCount){
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    break;
                }
            }
        }
        return answer;
    }
}