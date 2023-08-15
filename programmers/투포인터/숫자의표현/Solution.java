package programmers.투포인터.숫자의표현;

class Solution {
    public int solution(int n) {
        int answer = 0; //표현하는 방법의 수

        int leftNum = 0;
        int rightNum = 0;
        int tmpSum = leftNum + rightNum; //초기화

        while(leftNum<=n && rightNum <= n){
            if(tmpSum > n){
                tmpSum -= leftNum;
                leftNum++;
            }
            else if(tmpSum < n){
                rightNum++;
                tmpSum += rightNum;
            }
            else{
                answer++;
                rightNum++;
                tmpSum += rightNum;
            }
        }

        return answer;
    }
}
