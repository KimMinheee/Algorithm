package programmers.스택_큐.택배상자;

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int orderIdx = 0;
        int currentBox = 1;
        int answer = 0;

        Stack<Integer> subBelt = new Stack<>();
        while(orderIdx < order.length){

            if(order[orderIdx] == currentBox){
                answer++;
                currentBox++;
                orderIdx++;
            }
            else if(order[orderIdx] > currentBox){
                subBelt.push(currentBox);
                currentBox++;
            }
            else{
                //order[orderIdx] < currentBox
                //subBelt 확인
                while(!subBelt.isEmpty() && order[orderIdx] == subBelt.peek()){
                    subBelt.pop();
                    answer++;
                    orderIdx++;
                }

                if(orderIdx >= order.length) break;
                if(order[orderIdx] < currentBox) break;

            }

        }

        return answer;
    }
}
