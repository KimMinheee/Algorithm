package programmers.구현.n2배열자르기;


class Solution {
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int)(right-left+1)];
        int idx = 0;
        for(long i = left; i<=right; i++){
            answer[idx] = (int) Math.max(((i/n)+1), (i%n)+1);
            idx++;
        }

        return answer;
    }
}