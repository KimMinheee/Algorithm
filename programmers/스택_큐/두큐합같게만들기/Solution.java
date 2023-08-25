package programmers.스택_큐.두큐합같게만들기;

/**
 - [두 큐 합 같게 만들기]
 1. 두 배열에 들어있는 값을 모두 더해서 나누기 2
 2. 만약, 더한 값이 홀수라면 바로 -1을 return 한다.
 3. 두 큐는 deque을 이용하고 기준점을 하나로 잡는다.(deque1만 보기)
 */
import java.util.*;

class Solution {
    Deque<Integer> deque1 = new ArrayDeque<>();
    Deque<Integer> deque2 = new ArrayDeque<>();

    public int solution(int[] queue1, int[] queue2) {
        //deque에 데이터 세팅
        long sumQueue1 = 0;
        long sumQueue2 = 0;
        for(int i=0; i<queue1.length; i++){
            sumQueue1 += queue1[i];
            sumQueue2 += queue2[i];

            deque1.add(queue1[i]);
            deque2.add(queue2[i]);
        }

        long total = sumQueue1 + sumQueue2;
        if(total %2 != 0){
            return -1;
        }
        long targetValue = total/2;


        int answer = 0; //연산 횟수
        while(true){

            if(answer > (deque1.size()+deque2.size()+2)) return -1;

            if(sumQueue1 == targetValue){
                break;
            }
            else if(sumQueue1 < targetValue){
                //2에서 빼서 1에 넣기
                if(!deque2.isEmpty()){
                    int tmp = deque2.poll();
                    deque1.add(tmp);
                    sumQueue1 += tmp;
                    sumQueue2 -= tmp;
                }
                else return -1;

            }
            else{
                //1에서 빼서 2에 넣기
                if(!deque1.isEmpty()){
                    int tmp = deque1.poll();
                    deque2.add(tmp);
                    sumQueue1 -= tmp;
                    sumQueue2 += tmp;
                }
                else return -1;
            }
            answer++;
        }
        return answer;
    }
}
