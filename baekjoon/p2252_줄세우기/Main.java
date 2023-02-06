package baekjoon.p2252_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M; //N명의 학생, M개의 연산
    static List<Integer> connects = new ArrayList<>(); //학생 별 진입차수 저장하는 리스트.
    static StringBuilder sb = new StringBuilder();
    static List<ArrayList<Integer>> info = new ArrayList<>(); //연결 관계 저장하는 이중리스트.
    static Queue queue = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        info = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=N;i++){ //0은 없는걸로 침.
            info.add(new ArrayList<>());
            connects.add(0);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            //위상정렬 그래프 방향성 삽입.
            addGraph(a, b);
        }

        getTopological(); //진입차수가 0인것부터 하나씩 출력.

        System.out.println(sb.toString());
        }
    static void getTopological(){ //위상정렬
        //초기화
        for(int i=1; i<=N; i++){
            if(connects.get(i) == 0){
                queue.add(i);
            }
        }
        //while문 돌기
        while(!queue.isEmpty()){
            int tmp = (int) queue.poll();
            sb.append(tmp+" ");
            for(Integer i: info.get(tmp)){
                if(connects.get(i)>=1){
                    int afterMinus = connects.get(i)-1;
                    connects.set(i,afterMinus);
                    if(afterMinus == 0){
                        queue.add(i);
                    }
                }
            }
        }

    }
    static void addGraph(int a, int b){
        info.get(a).add(b);

        //connect 생성.
        if(connects.get(b)==0){
            connects.set(b,1);
        }
        else{
            int tmp = connects.get(b);
            connects.set(b,tmp+1);
        }
    }
}
