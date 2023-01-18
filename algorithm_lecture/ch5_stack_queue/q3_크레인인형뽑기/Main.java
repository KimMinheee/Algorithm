package algorithm_lecture.ch5_stack_queue.q3_크레인인형뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [][] map;
    static int m; //moves의 배열의 길이
    static int [] moves;
    static int [] idxArr; //각 열 기준으로 인덱스 값 저장 : 하나 뽑으면 행 인덱스 +1
    static int answer=0;
    static int solution(){
        Stack stack = new Stack();

        //각 열기준으로 인덱스 값 초기화
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[j][i]!=0) {
                    idxArr[i] = j;
                    break;
                }
            }
        }
        for(int move : moves){
            if(idxArr[move]>n) continue;
            int temp = map[idxArr[move]][move];

            idxArr[move]+=1;

            if(!stack.isEmpty()){
                if((int)stack.peek() == temp) {
                    stack.pop();
                    answer += 2;
                    continue;
                }
            }
            stack.push(temp);
        }

        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n+1][n+1];
        idxArr = new int[n+1];

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
