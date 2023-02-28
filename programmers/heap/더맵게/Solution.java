package programmers.heap.더맵게;

import java.util.PriorityQueue;
class Solution {

    public int solution(int[] scoville, int K) {
        int answer = getCount(scoville, K);
        return answer;
    }
    static int getCount(int[] scoville, int K){
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int cnt = 0;

        //힙에 넣기
        for(int s : scoville){
            que.add(s);
        }

        while(!que.isEmpty()){
            int tmp = que.peek();
            if(tmp < K){
                int worst = (int) que.poll();
                if(!que.isEmpty()){
                    int second = (int)que.poll();
                    int newScoville = worst + (second*2);
                    que.add(newScoville);
                    cnt++;
                }

                else{
                    return -1;
                }
            }
            else{
                return cnt;
            }
        }
        return cnt;
    }
}