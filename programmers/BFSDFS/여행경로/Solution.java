package programmers.BFSDFS.여행경로;
import java.util.*;

/**
 * [프로그래머스/여행경로]
 * - 2차원 배열로 저장되어 있는 티켓의 정보를 '공항'을 기준으로 hashMap에 넣는다.
 * - 한 번 넣을 때마다 hashMap의 value인 리스트를 sorting한다. -> 문자열의 알파벳순으로!(문제의 조건 중 경로가 여러가지면 알파벳순으로 제일 앞 출력)
 * - dfs
 *      : dfs의 매개변수인 count가 티켓의 개수와 동일하면 dfs를 return 한다. 다만 이때 단순히 return만 한다면 결과가 이미 나왔는데도 재귀 끝까지 돈다.
 *          boolean 타입의 isFinish 변수를 활용해 결과가 나왔으면 true로 바꿔준 후 dfs함수의 맨 상단에서 비교한 후 return 하여 불필요한 반복을 최대한 줄인다
 *      - dfs의 매개변수로 들어온 공항에서 갈 수 있는 다른 공항을 for문을 이용해 탐색한다.
 *      - 이때 사용한 적이 있는 항공편인지 비교해야 한다.
 *      - 사용한 적 없는 항공편이라면 항공편 사용 횟수(count)+1, 항공편 사용 처리, 정답 경로를 저장하는 arrayList에 값을 넣고 재귀로 dfs 를 돌린다.
 *      - 정답값을 찾아서 isFinish가 true가 되고, answer 리스트가 다 채워졌다고 가정하자. 이 경우 백트래킹을 할 필요가 없다.
 *      - dfs(tmp.dest,count); 다음에 실행될 백트래킹 작업이 isFinish가 false인 경우에만 실행 하도록 조건문을 추가해야한다.(아니면 다 완성됐는데 백트래킹으로 이상한 값이 된다.)
 */
class Solution {
    static HashMap<String, List<Airline>> map = new HashMap();
    static List<String> answer = new ArrayList<>();
    static int ticketSize;
    static boolean isFinish = false;

    public String[] solution(String[][] tickets) {
        ticketSize = tickets.length;

        //map에 세팅.
        for(String[] strings : tickets){
            if(map.containsKey(strings[0])){
                List<Airline> list = map.get(strings[0]);
                list.add(new Airline(strings[1],false));
                Collections.sort(list);
                map.put(strings[0],list);
            }
            else{ //아직 hashmap에 키로 존재하지 않는 공항의 경우.
                List<Airline> list = new ArrayList<Airline>();
                list.add(new Airline(strings[1],false));
                Collections.sort(list);
                map.put(strings[0],list);
            }

            if(!map.containsKey(strings[1])){ //도착하는 공항이 map에 존재하지 않는다면 -> 해당 공항에서 출발하지는 않지만 map에는 넣어둔다.
                map.put(strings[1],new ArrayList<Airline>());
            }
        }


        answer.add("ICN"); //ICN에서 시작.
        dfs("ICN",0);

        String[] answer2 = new String[answer.size()];
        for(int i=0; i<answer.size(); i++){
            answer2[i] = answer.get(i);
        }
        return answer2;
    }

    static void dfs(String airport, int count){
        if(isFinish) return;

        if(count == ticketSize){
            isFinish = true;
            return;
        }

        //icn에서 시작.
        for(int i=0; i<map.get(airport).size(); i++){
            Airline tmp = map.get(airport).get(i);
            if(tmp.isVisit == false ){
                count++;
                map.get(airport).get(i).isVisit = true;
                answer.add(tmp.dest);
                dfs(tmp.dest,count);
                if(!isFinish)
                {   count--;
                    map.get(airport).get(i).isVisit = false;
                    int removeIdx = answer.lastIndexOf(tmp.dest);
                    answer.remove(removeIdx);
                }
            }
        }

    }

}
class Airline implements Comparable<Airline>{
    String dest;
    boolean isVisit;

    public Airline(String dest, boolean isVisit){
        this.dest = dest;
        this.isVisit = isVisit;
    }

    @Override
    public int compareTo(Airline o) {
        return this.dest.compareTo(o.dest);
    }
}