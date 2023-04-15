package programmers.그리디.구명보트;
import java.util.*;

/**
 * [효율성 개선한 풀이]-----------------------------------------------------------
 * 가장 무거운 사람 + 가장 가벼운 사람이 한 보트에 탈 수 있는지를 고민
 * front 인덱스를 변수로 따로 가져간다.
 * for문을 돌 때 무거운 사람 부터 확인한다. front의 무게와 현재 가장 무거운 사람의 합이 limit 이하면 front를 +1한다.
 * -> 이미 한 배에 태웠으니 고려하지 않아도 된다. 다음으로 가벼운 사람으로 인덱스 넘어감.
 * -> 만약 limit보다 크다면 어쨌든 배 하나에 태워야 하니 answer는 똑같이 +1
 */
public class Solution2 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int front = 0;

        for(int i=people.length-1; i>=front; i--){
            if(people[i]+people[front] <= limit){
                front++;
            }
            answer++;
        }

        System.out.println(answer);
        return answer;

    }
    public static void main(String[] args){
        Solution2 sol = new Solution2();
        int[] data = {100, 500, 500, 900, 950};
        sol.solution(data,1000);
    }
}
