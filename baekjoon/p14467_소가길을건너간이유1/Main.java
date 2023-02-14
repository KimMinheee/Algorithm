package baekjoon.p14467_소가길을건너간이유1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static HashMap hashMap = new HashMap<>();
    static int answer=0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            String pos  = st.nextToken();
            if(hashMap.containsKey(num)){
                if(!hashMap.get(num).equals(pos)){
                    hashMap.put(num,pos);
                    answer++;
                }
            }
            else{
                hashMap.put(num,pos);
            }
        }
        System.out.println(answer);
    }
}
