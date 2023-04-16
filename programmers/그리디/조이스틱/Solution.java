package programmers.그리디.조이스틱;

import java.util.*;

/**
 * A인 경우 찾기 - > N까지는 앞에서 출발하는게 더 빠르다.
 *
 * ㅣ - 뒤 : 15 //앞 11
 * m - 뒤 : 14 / 앞 12
 * n - 앞: 13 / 뒤 : 13
 */

/**
 * 최종 정리 :
 * 1. 왼쪽방향으로 가는 것
 * 2. 오른쪽 방향으로 가는 것
 * 1,2 둘중에 최소를 구한다.
 */
//a b c d e f g h i j k l m n o p q r s t u v w x y z
class Solution {
    public int solution(String name) {
        int answer = Integer.MAX_VALUE;

        //다 A라면 0을 return
        String a = "A";
        if(name.equals(a.repeat(4))) return 0;

        //오른쪽 방향으로 감(정방향)
        int count = 0;
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i) <= 'N'){
                //a부터 출발
                count += name.charAt(i) - 'A';
            }
            else{
                //역으로 A->Z->Y->X 로 출발
                count += 'Z' - name.charAt(i) + 1;
            }
            if(i!=name.length()-1) count++;
        }

        answer = Math.min(answer,count);

        count = 0; //초기화
        //왼쪽 방향으로 감(역방향)

        //인덱스 = 0
        if(name.charAt(0) <= 'N') count+= name.charAt(0) - 'A';
        else count += 'Z' - name.charAt(0) + 1;

        int cursor = 0;
        //맨 끝부터
        for(int i=name.length()-1; i>0; i--){ //idx 0 은 처음에 이미 처리
            if(name.charAt(i) == 'A'){
                if(i == 1) break;
            }

            if(name.charAt(i) <= 'N'){
                //a부터 출발
                count += name.charAt(i) - 'A';
            }
            else{
                //역으로 A->Z->Y->X 로 출발
                count += 'Z' - name.charAt(i) + 1;
            }
            count++;
        }

        answer = Math.min(answer,count);
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("BMOABA"));
    }
}
