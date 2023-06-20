package programmers.완전탐색.피로도;
import java.util.*;

public class Solution {
    static Pair[] pairArr;
    static boolean[] check;
    static int size;
    static int answer = 0; //답 - 던전의 최대 개수

    public int solution(int k, int[][] dungeons) {
        size = dungeons.length;
        pairArr = new Pair[size];
        check = new boolean[size];

        int idx = 0;
        for(int[] dungeon : dungeons){
            pairArr[idx] = new Pair(dungeon[0],dungeon[1]);
            idx++;
        }

        search(1,k);

        return answer;
    }

    public void search(int depth, int remain){
        for(int i=0; i<size; i++){
            if(!check[i]){
                check[i] = true;
                if(remain >= pairArr[i].minimumPiro && remain >= pairArr[i].consumePiro){
                    answer = Math.max(depth,answer);
                    search(depth+1, remain-pairArr[i].consumePiro);
                }
                check[i] = false;
            }
        }
    }
}

class Pair{
    int minimumPiro;
    int consumePiro;

    public Pair(int minimumPiro, int consumePiro){
        this.minimumPiro = minimumPiro;
        this.consumePiro = consumePiro;
    }
}
