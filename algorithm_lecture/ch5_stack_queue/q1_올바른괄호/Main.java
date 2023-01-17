package algorithm_lecture.ch5_stack_queue.q1_올바른괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    static String solution(String data){
        String answer = "NO";
        Stack st = new Stack();
        for(char ch : data.toCharArray()){
            if(ch=='(') st.push('(');
            else{
                if(!st.isEmpty()) st.pop();
                else return answer;
            }
        }
        if(st.isEmpty()) answer = "YES";
        return answer;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        System.out.println(solution(data));
    }
}
