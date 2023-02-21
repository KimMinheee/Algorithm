package baekjoon.p2798_블랙잭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M; //카드의 개수, 카드에 쓰인 수
    static int answer = 0;
    static int cards[];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards  = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        getNearestSum();
        System.out.println(answer);
    }
    static void getNearestSum(){
        int tmp = 0;
        for(int a=0; a<N-2; a++){
            tmp += cards[a];
            for(int b=a+1; b<N-1; b++){
                tmp += cards[b];

                int pointer = b+1;
                while(pointer<N){
                    tmp+=cards[pointer];
                    int diff = M - tmp;
                    if(diff<0){
                        tmp -= cards[pointer];
                        pointer++;
                        continue;
                    }
                    if(diff <= M-answer){
                        answer = tmp;
                    }
                    tmp -= cards[pointer];
                    pointer++;
                }
                tmp -= cards[b];
            }
            tmp -= cards[a];
        }
    }
}
