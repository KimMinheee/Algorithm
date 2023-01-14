package algorithm_lecture.ch4_HashMap_TreeSet.q2_아나그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap hashA = new HashMap();
    static HashMap hashB = new HashMap();
    static void solution(char[]a , char[]b){
        for(char aa : a){
            if(!hashA.containsKey(aa)){ //기존에 없는 값인 경우
                hashA.put(aa,1);
            }
            else{
                hashA.put(aa,(int)hashA.get(aa)+1);
            }
        }
        for(char bb : b){
            if(!hashB.containsKey(bb)){ //기존에 없는 값인 경우
                hashB.put(bb,1);
            }
            else{
                hashB.put(bb,(int)hashB.get(bb)+1);
            }
        }
        Set setA = hashA.entrySet();
        List listA = new ArrayList(setA);
        Collections.sort(listA, new Comp());

        Set setB = hashB.entrySet();
        List listB = new ArrayList(setB);
        Collections.sort(listB, new Comp());

        if(listA.equals(listB)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    static class Comp implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            if(o1 instanceof Map.Entry && o2 instanceof Map.Entry){
                char val1 = (char) ((Map.Entry)o1).getKey();
                char val2 = (char) ((Map.Entry)o2).getKey();

                return val1-val2; //내림차순
            }
            return -1;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        solution(a,b);
    }
}
