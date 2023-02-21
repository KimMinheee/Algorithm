package baekjoon.p7568_덩치;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [완전탐색]7568_덩치
 * 아이디어: 클래스(Comparable)로 내림차순 sort, 하나씩 꺼내서 비교. 덩치가 크지 않으면 등수는 그대로 유지
 */
public class Main {
    static int N;//전체 사람 수
    static Person[] people;
    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        people = new Person[N];
        answer = new int[N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[i] = new Person(weight,height);
        }

        getRank();

        for(int a : answer){
            sb.append(a+" ");
        }
        System.out.println(sb.toString());

    }
    static void getRank(){
        int rank = 1;

        for(int i=0; i<N; i++){
            int tmpWeight = people[i].weight;
            int tmpHeight = people[i].height;

            for(int j=0 ;j<N; j++){
                if(people[j].weight>tmpWeight && people[j].height>tmpHeight){
                    //나보다 덩치 큰 사람이 있는 경우
                    rank++;
                }
            }
            answer[i] = rank;
            rank = 1;
        }
    }
}
class Person {
    int weight;
    int height;
    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

}
