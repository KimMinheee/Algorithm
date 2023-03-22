package swea.p2046_신문헤드라인;

import java.io.*;

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String data = br.readLine();
        bw.write(data.toUpperCase());
        bw.flush();
        bw.close();
        br.close();
    }
}
