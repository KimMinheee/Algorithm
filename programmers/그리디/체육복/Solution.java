package programmers.그리디.체육복;

import java.util.*;

class Solution {
    static int[] data;
    public int solution(int n, int[] lost, int[] reserve) {
        data = new int[n+1]; //1~n까지
        Arrays.fill(data,1);

        //여벌 옷 가져온 학생이 도난당할 수 있으므로 1.여벌옷세팅 -> 2. 도난 순서여야 함.
        for(int reserveIdx : reserve){
            data[reserveIdx] = 2;
        }
        for(int lostIdx : lost){
            data[lostIdx] = data[lostIdx]-1;
        }

        for(int i=1; i<=n; i++){
            //왼,오
            if(i==1){
                //오른쪽만 탐색
                if(data[i] == 2){
                    if(data[i+1]==0){
                        data[i] = 1;
                        data[i+1] = 1;
                    }
                }
            }
            else if (i==n){
                //왼
                if(data[i] == 2){
                    if(data[i-1]==0){
                        data[i] = 1;
                        data[i-1] = 1;
                    }
                }
            }
            else{
                //왼->오 둘다
                if(data[i] == 2){
                    //왼
                    if(data[i-1]==0){
                        data[i] = 1;
                        data[i-1] = 1;
                        continue;
                    }

                    if(data[i+1] ==0 && data[i]==2){
                        data[i]=1;
                        data[i+1]=1;
                    }
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            if(data[i]>=1) answer++;
        }

        return answer;
    }
}