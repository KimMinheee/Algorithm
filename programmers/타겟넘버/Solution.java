package programmers.타겟넘버;

class Solution {
    static boolean[] visited;
    static int answer = 0;

    public int solution(int[] numbers, int target) {

        visited = new boolean[numbers.length];

        dfs(numbers,0,0,target,0);
        return answer;

    }
    static void dfs(int[] numbers, int depth, int sum, int target,int idx){
        if(depth == numbers.length){
            if(sum == target) answer++;
            return;
        }
        else{
            dfs(numbers, depth+1, sum+numbers[idx], target, idx+1);
            dfs(numbers, depth+1, sum-numbers[idx], target, idx+1);
        }
    }
}