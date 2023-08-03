package programmers.스택_큐.다리를지나는트럭;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; //걸리는 시간
        int totalWeight = 0;
        int idx = 0;
        Deque<Integer> deq = new ArrayDeque<>();

        while (true) {
            if (idx == truck_weights.length) {
                break;
            }
            //다리의 끝, 즉 큐가 다 차면 도달한 트럭의 무게를 뺌
            if (deq.size() == bridge_length) {
                totalWeight -= deq.removeFirst();
            } else if (totalWeight + truck_weights[idx] > weight) {
                deq.offer(0);
                answer++;
            } else {
                deq.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                answer++;
                idx++;
            }

        }
        return answer + bridge_length;
    }
}
