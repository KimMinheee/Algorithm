package swea.D1.p2027_대각선출력하기;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**

 출력형태)
 #++++
 +#+++
 ++#++
 +++#+
 ++++#

 */
public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] data = new char[5];
        StringBuilder sb = new StringBuilder();
        Arrays.fill(data,'+');
        for(int i=0; i<5; i++){
            data[i] = '#';
            sb.append(String.valueOf(data)+"\n");
            data[i] = '+';
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

