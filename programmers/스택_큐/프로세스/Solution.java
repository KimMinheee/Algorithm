package programmers.스택_큐.프로세스;

import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) { //2,1,3,2
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int order = 0;

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) { //3,2,2,1
                if (priorities[i] == pq.peek()) {
                    pq.poll(); //같으니까 뺌
                    order++;
                    if (i == location) {
                        return order;
                    }
                }
            }
        }

        return -1;
    }
}