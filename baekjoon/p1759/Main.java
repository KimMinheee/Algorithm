package baekjoon.p1759;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//L(암호의 자리수), C(문자의 개수)를 입력받는다.
//사전식으로 출력해야하고 하나씩 뽑아서 끝까지 탐색 -> 정렬 & dfs 사용

//dfs로 갖고다녀야 하는 값 : 인덱스 , depth, 자음개수, 모음개수
//dfs 순서
//1. 체크인
//2. 목적지에 도착했는가 : depth 확인 -> (일단 4개 채움) -> 그 4자리 수가 최소자음,모음 개수를 만족하는지 확인(print)
//3. 연결된 곳 순회 : 배열의 현재 인덱스 다음부터 하나씩
//4. 갈 수 있는 가 : visit 확인
//5. 간다
//6. 체크아웃


public class Main {
    static int L,C;
    static char[] input;
    static boolean[] visit;

    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream("Algorithm/baekjoon/P1759/input.txt"));
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        input = new char[C];
        visit = new boolean[C];

        for(int i=0; i<C; i++){
            input[i] = sc.next().charAt(0); //sc는 String으로 읽음.
        }

        Arrays.sort(input);

        for(int i=0; i<C;i++){
            char tmp = input[i];
            if (tmp=='a'||tmp=='e'||tmp=='i'||tmp=='o'||tmp=='u') { //자음
                dfs(i,1,0,1);
            }
            else{//모음
                dfs(i,1,1,0);
            }
        }
    }

    static void dfs(int index,int depth,int vowels, int consonants){
        //1. 체크인
        visit[index] = true;

        //2. 목적지인가
        if(depth == L){
            print(vowels, consonants);
        }
        //3. 연결된 곳을 순회
        for(int i=index+1; i<C; i++){
            //4. 갈 수 있는가
            if(visit[i]== false){
                //5. 간다. dfs
                if (input[i]=='a'||input[i]=='e'||input[i]=='i'||input[i]=='o'||input[i]=='u') { //자음
                    dfs(i,depth+1,vowels,consonants+1);
                }
                else{//모음
                    dfs(i,depth+1,vowels+1,consonants);
                }
            }
        }
        //6. 체크아웃
        visit[index] = false;
    }
    static void print(int vowels,int consonants){
        if(vowels>=2 && consonants>=1){
            for(int i=0; i<C; i++){
                if(visit[i]==true){
                    System.out.print(input[i]);
                }
            }
            System.out.println();
        }
    }
}
