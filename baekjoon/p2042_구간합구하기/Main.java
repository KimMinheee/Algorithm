package baekjoon.p2042_구간합구하기;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K; //수의 개수, 변경 일어나는 횟수, 구간의 합을 구하는 횟수
    static long[] tree; //tree 정보를 저장하는 배열
    static long[] nums; //입력받는 데이터를 저장하는 배열
    static int S =1; //leaf 노드의 시작 & size
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        HashMap hashMap = new HashMap();

        //데이터 읽기
        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        //S를 leafNode의 개수로 맞추기
        while (S < N) {
            S = S * 2;//2//4 -> 8 되어 나옴
        }
        //총 배열의 개수는 0포함하여 리프노드 개수 *2
        tree = new long[S * 2];

        init(); //초기화

        //update or query
        for (int i = 0; i < M * K; i++) {
            st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (problem == 1) { //update : b번째 수를 c로 update
                long diff = (long)(c- tree[S+b-1]);
                update(1,S,1,b+1,diff);
            } else { //query : 구간 합 구하기
                bw.write(query(1, S, 1, b, c)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static void update(int left, int right, int node, int target,long diff){
        //1. 연관 없음.
        if(target<left || target > right) {
            return;
        }
        if(node>tree.length) return; //node가 크기보다 더 커지는 경우가 발생해서
        else{ //연관 있음.(연관 있는 노드의 값을 모두 바꿔줘야 한다.)
            tree[node] += diff;
            if(left!=right){ //중간노드 일 경우
                int mid = left+right/2;
                update(left,mid,node*2,target,diff); //왼쪽 자식 재귀
                update(mid+1,right, node*2+1,target,diff); //오른쪽자식 재귀
            }

        }
    }
    static void init(){
        //leaf는 data로
        for(int i=0; i<N; i++){
            tree[S+i] = nums[i];
        }
        //내부 노드는 자식의 합
        for(int i=S-1; i>0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, long queryRight){
        if(node>tree.length) return 0;

        //1. 연관 없음.
        if(queryLeft > right || queryRight < left){
            return 0; //구간 합이므로 무용한 0을 반환
        }
        //2. 판단 가능
        else if(queryLeft <= left && right <= queryRight){
            return tree[node];
        }
        //3. 판단 불가(걸쳐있음) 위임
        else{
            int mid = (left+right)/2;
            long leftResult = query(left,mid,node*2,queryLeft,queryRight);
            long rightResult = query(mid+1,right, node*2+1, queryLeft, queryRight);

            return leftResult+rightResult;
        }
    }
}
