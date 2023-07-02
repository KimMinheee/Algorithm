package programmers.그리디.최솟값만들기;

import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        PriorityQueue<Integer> aPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> bPQ = new PriorityQueue<Integer>();
        for(int i=0; i<A.length; i++){
            aPQ.add(A[i]);
            bPQ.add(B[i]);
        }

        int answer = 0;
        while(!aPQ.isEmpty() && !bPQ.isEmpty()){
            answer += aPQ.poll() * bPQ.poll();
        }

        return answer;
    }
}
