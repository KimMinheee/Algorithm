package baekjoon.p1339_단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [완전탐색] 1339_단어수학
 */
public class Main {
    static int N;
    static String[] data;
    static Alpha[] alpha = new Alpha[26]; //num과 idx가 저장됨
    static int[] answer = new int[26]; //각각의 알파벳에 9부터 내림차순으로 저장된 int 배열(마지막 계산에 사용)

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        data = new String[N];

        for(int i=0; i<26; i++){
            alpha[i] = new Alpha(i,0); //alpha 배열 초기화
        }
        for(int i=0; i<N; i++){
            data[i] = br.readLine();
        }
        System.out.println(getMaxSum());

    }
    static int getMaxSum(){
        for(int i=0; i<N; i++){
            StringBuffer sb = new StringBuffer(data[i]);
            String tmp = sb.reverse().toString();

            for(int k=0; k<tmp.length(); k++){
                alpha[tmp.charAt(k)-'A'].num += (int) Math.pow(10,k);
            }
        }

        Arrays.sort(alpha); //내림차순으로 정렬

        //answer 배열에 9부터 차례로 넣음.
        int changeNum = 9;
        for(int i=0; i<alpha.length; i++){
            if(alpha[i].num == 0) continue;
            answer[alpha[i].idx] = changeNum;
            changeNum--;
        }

        //최소값 계산.
        int max = 0;
        for(int i=0; i<N; i++){
            StringBuffer sb = new StringBuffer(data[i]);
            String tmp = sb.reverse().toString();
            for(int j=0; j<tmp.length(); j++){
                max += answer[tmp.charAt(j)-'A']*Math.pow(10,j);
            }
        }

        return max;
    }
}
class Alpha implements Comparable<Alpha>{
    int idx;
    int num;

    public Alpha(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }

    @Override
    public int compareTo(Alpha o) {
        return o.num - this.num;
    }
}
