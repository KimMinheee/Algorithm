package algorithm_lecture.ch8_dfsbfs활용.q6_순열구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;//총 개수
    static int M;//뽑는 수
    static int[] data; //n개의 자연수
    static int[] answer;
    static boolean[] check; //사용한 적 있는 수인지 체크

    static void dfs(int depth, ArrayList remain,int index){

        if(depth == M){
            //출력
            for(Object a : answer){
                System.out.print((int)a + " ");
            }
            System.out.println();
            check[index] = false;

            return;
        }
        for(Object a : remain){
            int idx = (Integer)a;
            answer[depth] = data[idx];
            check[idx] = true;

            ArrayList remainArr = new ArrayList();

            for(int j=0; j<check.length; j++){
                if(check[j] == false){
                    remainArr.add(j); //사용된 적 없는 수의 인덱스를 add
                }
            }

            dfs(depth+1,remainArr,idx);
            check[idx] = false;

        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N];
        check = new boolean[N];
        answer = new int[M];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList remainArr;

        for(int i=0; i<data.length; i++){
            answer[0] = data[i]; //고정
            check[i] = true;
            remainArr = new ArrayList<>();
            for(int j=0; j<check.length; j++){
                if(check[j] == false){
                    remainArr.add(j); //사용된 적 없는 수의 인덱스를 add
                }
            }
            dfs(1, remainArr,i);
            check[i] = false;

        }

    }
}
