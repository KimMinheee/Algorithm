package baekjoon.p10828_스택;

import java.io.*;
import java.util.Stack;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            String method = data[0];
            if (method.equals("push")) {
                stack.add(toInt(data[1]));
            } else if (method.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
            } else if (method.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (method.equals("empty")) {
                if (stack.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            } else {
                //top
                if (stack.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }

        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int toInt(String data) {
        return Integer.parseInt(data);
    }
}
