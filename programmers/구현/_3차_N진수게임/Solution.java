package programmers.구현._3차_N진수게임;

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        List<String> data = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int length = 0;
        int value = 0;
        while (data.size() <= m * t) {
            String num = Integer.toString(value, n);
            Arrays.stream(num.split(""))
                    .map(s -> s.toUpperCase())
                    .forEach(data::add);

            value++;
        }

        int index = p - 1;
        while (sb.length() < t) {
            sb.append(data.get(index));
            index = index + m;
        }

        return sb.toString();
    }
}
