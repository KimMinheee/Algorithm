package programmers.스택_큐.뒤에있는큰수찾기;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        stack.add(0); //인덱스 0은 바로 stack에 add
        Arrays.fill(answer,-1);

        for(int i=1; i<numbers.length; i++){

            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }
}
