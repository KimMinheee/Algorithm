package baekjoon.p14425_문자열집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        int answer = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String input = br.readLine();
            set.add(input);
        }

        for(int i=0; i<M; i++){
            String testInput = br.readLine();
            if(set.contains(testInput)) answer++;
        }

        System.out.println(answer);
        br.close();
    }
}
