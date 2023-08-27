package programmers.dp.피보나치수;

class Solution {
    static final int DIVIDE = 1234567;

    public int solution(int n) {
        int[] answer = new int[n+1];
        answer[0] = 0;
        answer[1] = 1;

        for(int i=2; i<=n; i++){
            answer[i] = (answer[i-1] + answer[i-2]) % DIVIDE;
        }

        return answer[n];
    }
}
