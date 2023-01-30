package baekjoon.p1759;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int L,C;
    static char[] input;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Algorithm/baekjoon/P1759/input.txt"));
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        input = new char[C];
        for(int i=0; i<C; i++){
            input[i] = sc.next().charAt(0); //sc는 String으로 읽음.
        }

        Arrays.sort(input);

        //Starting point를 가상의 빈 노드로 -> for문 없이 호출 한 번으로 가능.
        //장점 : for문을 사용하면 중복된 코드(자음인지 확인)없이 사용가능.
        dfs(-1,0,0,0,"");

    }

    //length,ja,mo,pwd를 static 변수로 둔다면 체크인,체크아웃에서 갱신 해줘야 한다.
    static void dfs(int current,int length,int ja,int mo,String pwd){
        //1. 체크인 - 생략가능(오름차순으로 정렬된 걸 차례로 방문하기 때문)

        //2. 목적지인가 length == L -> 자,모 개수
        if(length == L){
            if(ja>=2 && mo>=1){
                System.out.println(pwd);
            }
        }
        //3. 연결된 곳을 순회 : current ~ C
        for(int i=current+1; i<C; i++){
            //4. 갈 수 있는가 - 생략 가능
            //5. 간다. - 자,모
            if (input[i]=='a'||input[i]=='e'||input[i]=='i'||input[i]=='o'||input[i]=='u'){
                dfs(i,length+1,ja,mo+1,pwd+input[i]);
            }
            else{
                dfs(i,length+1,ja+1,mo,pwd+input[i]);
            }

        }

        //6. 체크아웃 - 생략가능
    }
}
