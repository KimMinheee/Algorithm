package swea.p2063_중간값찾기;


import java.util.*;
import java.io.*;

/**
 * p2063_중간값찾기
 * : 문자열을 한 줄 읽은 후 split()으로 char[]화
 * -> 정수로 바꿔야된다. 추후 정렬하는 과정에서 String은 제대로 정렬 안된다!
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] intNums;

        String[] nums = br.readLine().split(" ");
        intNums = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            intNums[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(intNums);
        bw.write(String.valueOf(intNums[intNums.length/2]));
        bw.flush();
        bw.close();
        br.close();
    }
}