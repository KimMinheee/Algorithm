package baekjoon.p1935_후위표기식2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    static int N;
    static HashMap<Character,Integer> hashMap = new HashMap<>();
    static Stack<Double> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        char[] expressions = br.readLine().toCharArray();

        char start = 'A';
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            hashMap.put((char)(start+i),num);
        }

        for(int i=0; i< expressions.length; i++){
            double result = 0;
            char now = expressions[i];
            if(Character.isUpperCase(now)){
                stack.add(Double.valueOf(hashMap.get(now)));
            }
            else {
                double a = stack.pop();
                double b = stack.pop();

                if(now == '+'){
                    result = a + b;
                    stack.add(result);
                }
                else if(now == '-'){
                    result = b - a;
                    stack.add(result);
                }
                else if(now == '*') {
                    result = a * b;
                    stack.add(result);
                }
                else {
                    result = b / a;
                    stack.add(result);
                }
            }
        }
        bw.write(String.format("%.2f",stack.pop()));
        bw.flush();
        bw.close();
        br.close();
    }
}
