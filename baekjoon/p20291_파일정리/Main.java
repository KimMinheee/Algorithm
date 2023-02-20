package baekjoon.p20291_파일정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * [구현]20291_파일정리
 * - Hashmap, StringTokenizer -> "."로 split
 */
public class Main {
    static HashMap<String,Integer> hashMap = new HashMap();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
         st = new StringTokenizer(br.readLine(),".");
         st.nextToken();
         String extension = st.nextToken();

         plusExtension(extension);
        }

        printExtensions();
    }
    static void plusExtension(String extension){
        if(hashMap.containsKey(extension)){
            hashMap.put(extension,hashMap.get(extension)+1);
        }
        else{
            hashMap.put(extension,1);
        }
    }

    static void printExtensions(){ //확장자 출력
        Map<String,Integer> sortedMap = new TreeMap<>(hashMap);
        for(Map.Entry<String,Integer> entry : sortedMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
