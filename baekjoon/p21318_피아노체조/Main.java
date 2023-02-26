package baekjoon.p21318_피아노체조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/**
 * [구간합] p21318_피아노체조
 * - 실수하는 횟수를 미리 구한 누적합(부분합) 배열을 만들어 놓고 연산시 사용
 * - 경계값 잘 잡아야 함. -> 누적합은 구하려는 값 인덱스에서 1 마이너스 한 값을 빼야한다. & 마지막은 실수를 하지 않는다는것이 문제 조건이므로 끝 인덱스도 1 마이너스.
 */
public class Main {
    static int N,M;
    static int[] data;
    static int[] prefixSum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N+1];
        prefixSum = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        getPrefixSum(); //실수 횟수 부분합 구하기

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());

            int cnt = getMistakeCount2(startIdx, endIdx);
            sb.append(cnt+"\n");
        }
        System.out.println(sb.toString());

    }

    //이 메소드는 시간초과 발생 - 한 번만 하면 상관 없는데 여러번 연산 들어가면 시간초과다. -> 누적합으로 해당 위치에서의 누적 실수 횟수를 더하자.
    static int getMistakeCount(int startIdx, int endIdx){
        int cnt = 0;
        for(int i=startIdx; i<endIdx; i++){
            if(data[i]>data[i+1]) cnt++;
        }
        return cnt;
    }

    static int getMistakeCount2(int startIdx, int endIdx){ //미리 구해놓은 실수 개수 구간합(누적합)을 이용하여 구간 합 구하기.

        return prefixSum[endIdx-1] - prefixSum[startIdx-1];
    }
    static void getPrefixSum(){
        for(int i=1; i<N; i++){
            int tmp = 0;
            if(data[i]>data[i+1]) tmp = 1;
            prefixSum[i] = prefixSum[i-1]+tmp;
        }
    }
}

