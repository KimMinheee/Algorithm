package baekjoon.p10773_제로;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }

        int answer = 0;
        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        System.out.println(answer);
        br.close();

    }
}
