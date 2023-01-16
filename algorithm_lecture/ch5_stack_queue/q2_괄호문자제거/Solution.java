package algorithm_lecture.ch5_stack_queue.q2_괄호문자제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    static String solution(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(x==')'){
                while(stack.pop()!='(');
            }
            else{
                stack.push(x);
            }
        }

        for(int i=0; i<stack.size();i++){
            answer += stack.get(i);
        }
        return answer;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        System.out.println(solution(data));
    }
}
