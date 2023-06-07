package programmers.정렬.최댓값과최솟값;

import java.util.*;

class Solution {
    public String solution(String s) {
        List<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(String tmp: s.split(" ")){
            arr.add(Integer.valueOf(tmp));
        }
        Collections.sort(arr);

        sb.append(arr.get(0));
        sb.append(" ");
        sb.append(arr.get(arr.size()-1));

        return sb.toString();
    }
}