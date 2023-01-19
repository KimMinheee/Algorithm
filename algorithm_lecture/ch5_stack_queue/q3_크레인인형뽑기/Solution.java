package algorithm_lecture.ch5_stack_queue.q3_크레인인형뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int [][] map;
    static int m; //moves의 배열의 길이
    static int [] moves;
    static int solution(){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : moves){
            for(int i=1;i<=n;i++){
                if(map[i][pos]!=0) {
                    int tmp = map[i][pos];
                    map[i][pos] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    }
                    else stack.push(tmp);
                    break; //열에서 하나 뽑으면 바로 break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        moves = new int[m];
        for(int i=0; i<m; i++){
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

}
