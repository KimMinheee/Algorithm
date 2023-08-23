package programmers.구현._124나라의숫자;

public class Solution {
    final int[] data = new int[] {4, 1, 2};

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            int num = n % 3;
            sb.insert(0, data[num]);

            n = n-1;
            n /= 3;
        }
        return sb.toString();
    }
}
