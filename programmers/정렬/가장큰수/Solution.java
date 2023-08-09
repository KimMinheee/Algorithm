package programmers.정렬.가장큰수;

import java.util.*;

public class Solution {
    public String solution(int[] numbers) {
        String[] data = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            data[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (data[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : data) {
            sb.append(s);
        }

        return sb.toString();
    }
}
