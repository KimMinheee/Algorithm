package programmers.슬라이딩윈도우.연속된부분수열의합;

import java.util.*;

class Solution {

    public int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        List<Info> kList = new ArrayList<>();
        int lt = 0, rt = 0;
        int tmpSum = 0;

        while(lt < N && rt < N){

            if(tmpSum > k){
                tmpSum -= sequence[lt];
                lt++;
            }
            else if(tmpSum < k){
                tmpSum += sequence[rt];
                rt++;
            }
            else{//tmpSum == k
                kList.add(new Info(lt,rt,(rt-lt+1)));
                if(rt < N-1){
                    rt++;
                    tmpSum += sequence[rt];
                }
            }
        }

        //정렬
        Collections.sort(kList);

        int[] answer = new int[] {kList.get(0).start, kList.get(0).end};
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("aazz");
        Solution sol = new Solution();
        int[] data = new int[] {1,2,3,4,5};
        int k = 7;
        System.out.println(Arrays.toString(sol.solution(data, k)));
    }
}
class Info implements Comparable<Info>{
    int start; //시작 인덱스
    int end;//끝 인덱스
    int count; //개수

    public Info(int start, int end, int count){
        this.start = start;
        this.end = end;
        this.count = count;
    }

    @Override
    public int compareTo(Info info2){
        int tmp = this.count - info2.count;
        if(tmp == 0){
            return this.start - info2.start;
        }
        return tmp;
    }
}
