package algorithm_lecture.ch4_HashMap_TreeSet.q1_학급회장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int num;
    static HashMap map = new HashMap();
    static void solution(){
        Set set = map.entrySet();
        List list = new ArrayList(set);

        Collections.sort(list,new Comp());

        Map.Entry e = (Map.Entry)list.get(0);

        System.out.println(e.getKey().toString());
    }

    static class Comp implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            if(o1 instanceof Map.Entry && o2 instanceof Map.Entry){
                int val1 = (int) ((Map.Entry)o1).getValue();
                int val2 = (int) ((Map.Entry)o2).getValue();

                return val2- val1; //내림차순
            }
            return -1;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        String[] st = br.readLine().split("");

        //hashmap에 데이터 입력
        for(int i=0; i<num; i++){
            if(map.containsKey(st[i])){
                map.put(st[i],(Integer)map.get(st[i])+1);
            }
            else{
                map.put(st[i],new Integer(1));
            }
        }

        solution();
    }

}
