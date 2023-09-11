package programmers.구현.호텔대실;

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] arr = new int[1450]; // 60 * 24 + a(청소시간)

        int[][] times = new int[book_time.length][2];

        for (int i=0; i< book_time.length; i++) {
            times[i] = convertTime(book_time[i]);
        }

        for (int i=0; i<times.length; i++) {
            fillArr(times[i][0], times[i][1], arr);
        }

        //방 개수
        for (int i=0; i < arr.length; i++) {
            answer = Math.max(answer, arr[i]);
        }

        return answer;
    }

    private void fillArr(int s, int e, int[] arr) {
        for (int i=s; i <=e; i++) {
            arr[i] += 1;
        }
    }

    private int[] convertTime(String[] books) {
        int start = Integer.parseInt(books[0].substring(0, 2)) * 60 + Integer.parseInt(books[0].substring(3, 5));
        int end = Integer.parseInt(books[1].substring(0, 2)) * 60 + Integer.parseInt(books[1].substring(3, 5)) + 9;

        return new int[] {start, end};
    }
}
