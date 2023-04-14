package programmers.그리디.구명보트;

import java.util.*;
class Solution {
    static boolean[] check;

    public int solution(int[] people, int limit) {
        int answer = 0;
        check = new boolean[people.length];

        Arrays.sort(people);

        for(int i=0; i<people.length; i++){

            int minDiff = Integer.MAX_VALUE;
            int minIdx = -1;

            if(!check[i]){
                int num = people[i];
                check[i] = true;

                for(int j=i+1; j<people.length; j++){
                    if(!check[j]){
                        if(limit-(num+people[j]) >= 0){
                            if(minDiff > limit-(num+people[j])){
                                minIdx = j;
                                minDiff = limit - (num + people[j]);
                            }
                        }
                    }
                }

                if(minIdx == -1){ //두명을 태울 수 없는 경우
                    answer++;
                    for(int j=0; j<people.length; j++){
                        if(!check[j]) answer ++;
                    }
                    break;
                }
                else{ //두명을 태울 수 있는 경우.
                    check[minIdx] = true;
                    answer++;
                }
            }

        }
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] data = {100, 500, 500, 900, 950};
        sol.solution(data,1000);
    }
}
class Person implements Comparable<Person>{
    int idx;
    int weight;

    public Person(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person p2){
        int tmp = this.weight - p2.weight;
        if(tmp == 0) return this.idx - p2.idx;
        return tmp;
    }
}