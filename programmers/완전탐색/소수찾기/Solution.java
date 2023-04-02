package programmers.완전탐색.소수찾기;

import java.util.*;
class Solution {
    static HashMap<Character,Integer> hashMap = new HashMap<>();
    static HashSet<Integer> hashSet = new HashSet<>(); //같은 것이 있는 순열을 저장하는 hashSet.
    public int solution(String numbers) {
        int answer = 0;

        //숫자 개수 hashMap에 저장.
        for(int i=0; i<numbers.length(); i++){
            char num = numbers.charAt(i);
            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }
            else hashMap.put(num,1);
        }

        //같은 것이 있는 순열로 조합 후 소수 판정
        //1. 같은 것이 있는 순열 : depth가 1자리 ~ numbers.length()자리 인 경우를 모두 확인한다.
        for(int maxDepth=1; maxDepth<=numbers.length(); maxDepth++){
            dfs(0,"",maxDepth);
        }

       //2. 소수판정 :가장 큰 값을 골라서 에라토스테네스체 구현, hashSet과 비교하여 counting
        int max = hashSet.stream().mapToInt(x->x).max().getAsInt();

        return getPrimeCount(max);
    }
    static int getPrimeCount(int max){
        int answer = 0;

        //에라토스테네스체 사용
        int[] numberArray = new int[max+1];
        for(int i=2; i<=max; i++){
            if(numberArray[i] == 0){
                for(int j=2; j*i<=max; j++){
                    numberArray[j*i] = 1; //소수가 아닌것 1로 바꾸기
                }
            }
        }
        for(int num : hashSet){
            if(numberArray[num] == 0 && num>1) {answer++;}
        }

        return answer;

    }
    static void dfs(int depth, String route, int maxDepth){
        if(depth == maxDepth){
            hashSet.add(Integer.parseInt(route));
            return; //종료
        }
        for(Character key : hashMap.keySet()){
            int value = hashMap.get(key);
            if(value >= 1){
                hashMap.put(key,value-1);
                dfs(depth+1,route+key,maxDepth);
                hashMap.put(key,hashMap.get(key)+1); //백트래킹 원복시 value값과 달라져 있는것 주의
            }
        }
    }

    //테스트용 main함수
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.solution("1231");
    }
}