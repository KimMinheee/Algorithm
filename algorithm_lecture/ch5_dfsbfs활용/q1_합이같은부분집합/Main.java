package algorithm_lecture.ch5_dfsbfs활용.q1_합이같은부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] data; //집합의 원소 배열 - n개
    static int[] ch; //
    static ArrayList<ArrayList<Integer>> arr;
    static int num;
    static int cnt = 0 ;

    public static void dfs(int a){
        if(a == num){//마지막 배열 이후라면
            for(int i=0; i<ch.length; i++){
                if(ch[i]==1) arr.get(cnt).add(data[i]); //ch의 값이 1이라면 부분집합 원소로 추가.
            }
            cnt++;
            return;
        }

        ch[a] = 1;
        dfs(a+1);
        ch[a] = 0;
        dfs(a+1);
    }

    public static void solution(){
        dfs(0); //부분집합 배열에 저장.

        for(int i=1; i<(int)Math.pow(2,num); i++){
            int sum1 = 0;
            for(int p : arr.get(i)) sum1 = sum1 + p;

            int sum2 = 0;
            for(int p : arr.get((int)Math.pow(2,num)-1-i)) sum2 = sum2 + p;


            if(sum1 == sum2){
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        arr = new ArrayList<ArrayList<Integer>>();
        ch = new int[num];
        data = new int[num];

        //리스트 초기화 - n+1개 만들어야 한다.
        for(int i=0; i<(int)Math.pow(2,num); i++){
            arr.add(new ArrayList<Integer>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data); //데이터 오름차순으로 정렬.

        solution();
    }
}
