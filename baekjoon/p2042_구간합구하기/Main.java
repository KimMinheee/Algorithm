package baekjoon.p2042_구간합구하기;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K; // 수의 개수, 변경 일어나는 횟수, 구간의 합을 구하는 횟수
    static long[] tree; // tree 정보를 저장하는 배열
    static long[] nums; // 입력받는 데이터를 저장하는 배열
    static int S = 1; // leaf 노드의 시작 & size

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 데이터 읽기
        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        // S를 leafNode의 개수로 맞추기
        while (S < N) {
            S = S * 2; // 2 // 4 -> 8
        }
        // 총 배열의 개수는 0을 포함하여 리프노드 개수 * 2
        tree = new long[S * 2];

        init(); // 초기화

        // update or query
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (problem == 1) { // update : b번째 수를 c로 update
                long diff = c - nums[b - 1];
                nums[b - 1] = c; // nums 배열 업데이트
                update(1, S, 1, b, diff);
            } else { // query : 구간 합 구하기
                bw.write(query(1, S, 1, b, (int) c) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void update(int left, int right, int node, int target, long diff) {
        if (target < left || target > right) {
            return;
        }
        tree[node] += diff;
        if (left != right) {
            int mid = (left + right) / 2;
            update(left, mid, node * 2, target, diff);
            update(mid + 1, right, node * 2 + 1, target, diff);
        }
    }

    static void init() {
        // leaf는 data로
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        // 내부 노드는 자식의 합
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left) {
            return 0;
        }
        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        int mid = (left + right) / 2;
        return query(left, mid, node * 2, queryLeft, queryRight) +
                query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
    }
}
