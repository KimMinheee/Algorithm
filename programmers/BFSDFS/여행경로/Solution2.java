package programmers.BFSDFS.여행경로;

import java.util.*;

/**
 * 공항 기준인 항공편(티켓)기준!
 */
class Solution2 {
    static List<String> answerList = new ArrayList<String>();
    static boolean[] check;
    public String[] solution(String[][] tickets) {
        int count = 0;
        check = new boolean[tickets.length];

        dfs("ICN","ICN",tickets,count);

        Collections.sort(answerList); //오름차순으로

        String answer[] = answerList.get(0).split(" ");

        return answer;
    }
    static void dfs(String start,String route, String[][] tickets , int count){
        if(count == tickets.length){
            answerList.add(route); //발견되는 경로를 계속 add
            return;
        }

        for(int a=0; a<tickets.length; a++){
            if(check[a] == false && start.equals(tickets[a][0])){ //사용한적 없는 티켓이면서 매개변수로 온 시작점과 동일한 항공권이라면
                check[a] = true;
                dfs(tickets[a][1],route+" "+tickets[a][1], tickets, count+1);
                check[a] = false;
            }
        }
    }

}

