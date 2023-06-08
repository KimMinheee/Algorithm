package programmers.구현.행렬의곱셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length]; //앞쪽 행, 뒤쪽 열

        for(int a=0; a<arr1.length; a++){ //a의 행 개수 만큼 반복
            for(int b=0; b<arr2[0].length; b++){ //b의 열 개수 만큼 반복
                for(int c=0; c<arr1[0].length; c++){ //a의 열 개수(b의 행 개수)만큼 연산 반복.
                    answer[a][b] += arr1[a][c] * arr2[c][b];
                }
            }
        }


        return answer;
    }
}