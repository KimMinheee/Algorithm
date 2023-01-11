package algorithm_lecture.ch7_recursive_tree_graph.q4_피보나치재귀_메모이제이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//피보나치 수열은 재귀보다 for문으로 반복하는 것이 더 효율이 좋음.
public class Main {
    static int[] fibo; //default가 0으로 초기화

    //반복문을 활용 ver
    public static int dfs(int num){
        if(num==1) return 1;
        else if(num==2) return 1;
        else{
            return dfs(num-1)+dfs(num-2);
        }
    }

    //속도 개선 ver
    public static int dfs2(int num){
        if(num==1) {
            return fibo[num]=1;
        }
        else if(num==2){
            return fibo[num]=1;
        }
        else{
            return fibo[num] = dfs2(num-1)+dfs2(num-2);
        }
    }

    //메모이제이션을 적극 활용한 향상된 속도 개선 ver
    public static int dfs3(int num){
        //계산한 적이 있다면(int 배열의 값이 0보다 크다면) 저장해둔 해당 값을 바로 반환함. -> 반복 x
        if(fibo[num]>0) return fibo[num];

        if(num == 1) return fibo[num] = 1;
        else if(num == 2) return fibo[num] = 1;
        else{
            return fibo[num] = dfs3(num-2)+dfs3(num-1);
        }
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        fibo = new int[num+1];
        dfs3(num);

        //이렇게 for문 도는건 비효율적 -> 값이 45로 커지면 너무 오래 걸림.
        //for(int i =1 ; i<=num; i++) System.out.print(dfs(i)+" ");

        //값 저장 배열 사용
        for(int i=1; i<=num; i++) System.out.print(fibo[i]+" ");
    }
}
