package swea.D2.p2007_패턴마디의길이;

import java.io.*;
/*
3
KOREAKOREAKOREAKOREAKOREAKOREA
SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA
GALAXYGALAXYGALAXYGALAXYGALAXY
 */

public class Solution {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=T; test_case++){
            String data = br.readLine();
            sb.append("#"+test_case+" ");
            sb.append(String.valueOf(getWordLength(data))+"\n");
        }
        System.out.println(sb.toString());
    }
    static int getWordLength(String data){
        int answer = 0;
        int dataLength = data.length();

        for(int i=1; i<=10; i++){ //마디의 최대길이는 10
            //if(dataLength % i != 0) continue;
            int wordSize = data.length() / i ; //마디의 개수

            int idx=0;
            String before = data.substring(idx,idx+i);

            int count = 1;
            for(int j=idx+i; j<dataLength; j=j+i){
                if(dataLength - j < i){
                    if(count == wordSize){answer = i; return answer;}
                }
                if(!data.substring(j,j+i).equals(before)) break;
                count++;
                if(count == wordSize){ answer = i; return answer;}
            }
        }
        return answer;
    }
}
