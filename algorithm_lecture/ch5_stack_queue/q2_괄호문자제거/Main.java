package algorithm_lecture.ch5_stack_queue.q2_괄호문자제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static void solution(String data){
        Queue que = new LinkedList();
        int req = 0;

        char[] arrData = data.toCharArray();
        for(char a : arrData){
            que.add(a);
        }

        while(!que.isEmpty()){
            char c = (Character) que.poll();
            if(c=='(') req++;
            else if(c==')') req--;
            else if(req==0) System.out.print(c);
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        solution(data);
    }
}
