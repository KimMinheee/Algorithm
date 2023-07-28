package programmers.BFSDFS.숫자변환하기;

import java.util.*;

class Solution {
    int[] arr = new int[1000001]; //1 ≤ x ≤ y ≤ 1,000,000
    Queue<Integer> que = new LinkedList<>();

    public int solution(int x, int y, int n) {
        if(x == y) {
            return 0; //바로 종료
        }
        que.add(x);

        while(!que.isEmpty()){
            int num = que.poll();
            int[] tempArr = new int[3];

            tempArr[0] = num + n;
            tempArr[1] = num * 2;
            tempArr[2] = num * 3;

            for(int i=0; i<3; i++){
                int tempResult = tempArr[i];
                if(tempResult > y){
                    continue; //다음 연산으로 넘어감
                }
                if(arr[tempResult] ==0 || arr[tempResult] -1 >arr[num]){
                    arr[tempResult] = arr[num] + 1; //현재 숫자 num 단계 포함
                    que.add(tempResult);
                }
            }
        }

        if(arr[y] == 0){
            return -1;
        }
        else return arr[y];
    }
}
