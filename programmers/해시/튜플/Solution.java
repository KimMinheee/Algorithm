package programmers.해시.튜플;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        //substring(start, end)  => "" "{3}" (1,length-1) (1,2) -> "3" ""

        HashSet<Integer> set = new LinkedHashSet<>();
        s= s.replace("{","");
        s= s.replace("},","!");
        s= s.replace("}}",""); //마지막은 ! 붙이면 x


        String [] array = s.split("!");
        Arrays.sort(array,new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length()); //오름차순
            }
        });

        for(int  i = 0 ;i<array.length;i++){
            String [] chars = array[i].split(",");
            for(int j = 0 ;j<chars.length ; j++){
                int num = Integer.parseInt(chars[j]);
                if(!set.contains(num)){
                    set.add(num);
                }
            }
        }

        //int[]
        int[] answer = new int[set.size()];
        int idx=0;
        for(Integer i : set){
            answer[idx++] = i;
        }
        return answer;
    }
}
