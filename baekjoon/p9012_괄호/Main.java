package baekjoon.p9012_괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            if(isVPS(tmp)) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    static boolean isVPS(String s){
        char[] chars = s.toCharArray();
        Stack psStack = new Stack();
        for(char c : chars){
            if(c == '(') psStack.push(c);
            else{
                if(!psStack.isEmpty()) psStack.pop();
                else{
                    return false;
                }
            }
        }

        if(!psStack.isEmpty()) return false; //다 돌고와서도 stack에 뭐가 남아있다면
        else return true;
    }
}

