package programmers.완전탐색.최소직사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int[] large = new int[sizes.length];
        int[] small = new int[sizes.length];

        for(int i=0; i<sizes.length; i++){
            int smallOne = Math.min(sizes[i][0],sizes[i][1]);
            int largeOne = Math.max(sizes[i][0],sizes[i][1]);
            large[i] = largeOne;
            small[i] = smallOne;
        }
        int maxInLarge = Arrays.stream(large).max().getAsInt();
        int maxInSmall = Arrays.stream(small).max().getAsInt();

        answer = maxInLarge * maxInSmall;
        return answer;

    }
}