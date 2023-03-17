package programmers.스택_큐.올바른괄호;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] charList = s.toCharArray();
        Stack<Character> stack = new Stack();

        for(char c : charList){
            if(c == '(') stack.push('(');
            else{
                if(stack.isEmpty()){
                    answer = false;
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) answer = false;
        else answer = true;

        return answer;
    }
}