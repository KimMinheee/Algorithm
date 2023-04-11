package programmers.그리디.큰수만들기;

import java.util.*;

/*
- 배열의 순서는 계속 가지고 가야됨.
*/

class Solution {
    static int num;
    static int[] numberArr; //String number int배열화
    static int[] answer;
    static boolean[] check;
    static int maxValue = Integer.MIN_VALUE;

    public String solution(String number, int k) {
        numberArr = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        num = numberArr.length - k;
        answer = new int[num];
        check = new boolean[numberArr.length];

        dfs(0,0,k);
        return String.valueOf(maxValue);

    }
    static void dfs(int index, int depth,int k){

        if(depth == num){

            int tmp = 0;
            for(int i=0; i<num; i++){
                //tmp = tmp +(int) Math.pow(10,num-i-1)*answer[i];
                tmp *= 10;
                tmp += answer[i];
            }

            maxValue = Math.max(tmp, maxValue);
            return;
        }

        for(int i=index; i<numberArr.length; i++){
            if(!check[i]){
                check[i] = true;
                answer[depth] = numberArr[i];
                dfs(i+1,depth+1,k);
                check[i] = false;
            }
        }
    }
}