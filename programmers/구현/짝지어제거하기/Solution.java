package programmers.구현.짝지어제거하기;

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        stack.add(charArray[0]);

        for(int i=1; i<charArray.length; i++){
            char tmp = charArray[i];
            if(!stack.isEmpty() && stack.peek() == tmp) stack.pop();

            else stack.add(tmp);        }

        if(stack.isEmpty()) return 1;
        else return 0;
    }
}
