package baekjoon.p1991_트리순회;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] data;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        data = new int[2][N];

        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            data[0][node] = left;
            data[1][node] = right;
        }

        //전위 순회
        preOrder(0);
        sb.append("\n");
        //중위 순회
        inOrder(0);
        sb.append("\n");
        //후위 순회
        postOrder(0);
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void preOrder(int num){
        if(num == -19) return; //자식이 없는 경우
        sb.append((char) (num + 'A')); //현재
        preOrder(data[0][num]); //왼쪽 자식
        preOrder(data[1][num]); //오른쪽 자식
    }

    static void inOrder(int num){
        if(num == -19) return;
        inOrder(data[0][num]);
        sb.append((char) (num + 'A'));
        inOrder(data[1][num]);
    }

    static void postOrder(int num){
        if(num == -19) return;
        postOrder(data[0][num]);
        postOrder(data[1][num]);
        sb.append((char) (num + 'A'));
    }

}
