package programmers.구현.나머지가1이되는수찾기;

class Solution {
    public int solution(int n) {
        int divide = 1;
        while(true){
            if(n % divide == 1){
                return divide;
            }
            divide++;
        }
    }
}
