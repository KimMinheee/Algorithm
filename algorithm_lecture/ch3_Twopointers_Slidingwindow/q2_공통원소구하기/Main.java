package algorithm_lecture.ch3_Twopointers_Slidingwindow.q2_공통원소구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static String solution(ArrayList arr1, ArrayList arr2,int num1, int num2){
        String answer ="";
        List resultList = new ArrayList();
        int p1 =0;//배열1의 포인터
        int p2 =0;//배열2의 포인터

        Collections.sort(arr1);
        Collections.sort(arr2);

        //같은 수 배열에 넣기
        while(p1<num1 && p2<num2){

            if((Integer)arr1.get(p1) < ((Integer)arr2.get(p2))){
                p1++;
            }
            else if((int)arr1.get(p1) > (int)arr2.get(p2)){
                p2++;
            }
            else{
                resultList.add(arr1.get(p1));
                p1++;
                p2++;
            }
        }


        //정렬
        Collections.sort(resultList);

        //result 문자열
        for(Object c : resultList){
            answer = answer + c.toString()+" ";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList arr1 = new ArrayList<>(num1);
        while(st.hasMoreTokens()){
            arr1.add(Integer.parseInt(st.nextToken()));
        }

        int num2 = Integer.parseInt(br.readLine());
        st =new StringTokenizer(br.readLine());
        ArrayList arr2 = new ArrayList<>(num2);
        while(st.hasMoreTokens()){
            arr2.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution(arr1,arr2,num1,num2));

    }
}
