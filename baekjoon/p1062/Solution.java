package baekjoon.p1062;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static int n,k;
    static boolean[] visited;
    static String[] words;
    static int selectedCount;// depth
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Algorithm/baekjoon/P1062/input.txt")); //추후 여기 주석처리하면 된다. 테스트할때 계속 복붙하지 않아도 됨.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[26];
        visited['a'-'a'] = true;
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;

        words = new String[n];
        for(int i=0; i<n; i++){
            words[i] = sc.next().replaceAll("[antic]","");
        }
        selectedCount = 5;

        //<케이스 처리>
        //k<5 -> 0
        if(k<5){
            System.out.println(0);
        }
        else if(k>5){
            for(int i=0; i<26;i++){
                if(visited[i]==false){
                    dfs(i);
                }
            }
            System.out.println(max);
        }
        else if(k==5){
            System.out.println(countReadable());
        }
        else if(k==26){
            System.out.println(26);
        }

    }

    static void dfs(int index){
        //1. 체크인 : visited, selectedCount
        visited[index] = true;
        selectedCount++;

        //2. 목적지인가 : selectedCount와 k가 같을 때(selectedCount == k) -> 읽을 수 있는 단어 계산
        //나중에 함수로 빼도 됨.
        if(selectedCount == k){
            max = Math.max(countReadable(),max); //비교하여 갱신
            //return 쓰면 안된다. checkout을 못하고 빠져나옴. 탐색을 완전히 종료해도 될 때만 return 사용.
        }
        else{
            //3. 연결된 곳을 순회 : a~z / 현재(current)보다 큰 곳(4로 놔도 됨)=index+1
            for(int i=index+1;i<26;i++){
                //4. 갈 수 있는가? : visited
                if(visited[i]==false){
                    dfs(i);
                }
            }
        }

        //6. 체크아웃 : visited, selectedCount
        visited[index] = false;
        selectedCount--;
    }

    static int countReadable(){
        int cnt = 0;

        for(int i=0; i<n;i++){ //단어의 총 개수만큼.
            boolean isReadable = true; //읽을 수 있는지

            String word = words[i];
            for(int j=0; j<word.length();j++){
                if(visited[word.charAt(j) - 'a'] == false){
                    isReadable = false;
                    break;
                }
            }
            if(isReadable) cnt++;
        }

        return cnt;
    }
}
