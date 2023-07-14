package programmers.구현.땅따먹기;

import java.util.Arrays;

class Solution {
    static int columnSize;

    int solution(int[][] land) {

        columnSize = land.length;

        for(int i = 1; i < columnSize; i++) {
            for(int j = 0; j < 4; j++) {
                int max = -1;

                //이전 배열에서 최대값 찾기
                for(int k = 0; k < 4; k++) {
                    if(j != k) {
                        max = Math.max(max, land[i - 1][k]);
                    }
                }
                land[i][j] += max;
            }
        }


        Arrays.sort(land[columnSize-1]);
        return land[columnSize - 1][3];
    }
}
