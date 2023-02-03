package baekjoon.p1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] check; //방문 처리
    static char[] exist = {'a','n','t','i','c'};
    static int n,k;
    static int max = Integer.MIN_VALUE;
    static int answer;
    static String[] data;

    static void dfs(int a, int depth){

        if(check[a] == 1){
            return;
        }
        //1. 체크인
        check[a] = 1;

        //2. 목적지인가
        if(depth==k-5){ //단어 구성가능한지 확인
            for(int p = 0; p<data.length ;p++){//단어의 개수만큼
                int tmp = 0;
                char[] chars = data[p].toCharArray();
                for(int q=0; q<chars.length;q++){//각 단어의 글자 수 만큼
                    if(check[chars[q]-'a'] == 1) tmp++;
                }

                if(tmp == chars.length) {
                    answer++;
                }
                max = Math.max(answer,max);
            }
        }

        if(depth<k-5){
            for(int p=a+1; p<26; p++){
                if(check[p]!=1){
                    dfs(p,depth+1);
                    if(!(p=='a'-'a'||p=='n'-'a'||p=='t'-'a'||p=='i'-'a'||p=='c'-'a')) check[p] = 0;
                }
            }
        }

        check[a]=0;
        answer = 0;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        data = new String[n];
        check = new int[26]; //총 알파벳 개수 만큼.

        for(int i=0; i<n; i++){
            data[i] = br.readLine();
        }

        //anta,tica의 5개 알파벳 방문 처리
        for(char c : exist){
            check[c-'a'] = 1;
        }

        if(k<5){
            System.out.println(0);
        }
        else if(k==5){
            for(int p = 0; p<data.length ;p++){//단어의 개수만큼
                int tmp = 0;
                char[] chars = data[p].toCharArray();
                for(int q=0; q<chars.length;q++){//각 단어의 글자 수 만큼
                    if(check[chars[q]-'a'] == 1) tmp++;
                }

                if(tmp == chars.length) {
                    answer++;
                }
                max = Math.max(answer,max);
            }
            System.out.println(max);
        }
        else{
            for(int i=0; i<26; i++){
                dfs(i,1);
                if(!(i=='a'-'a'||i=='n'-'a'||i=='t'-'a'||i=='i'-'a'||i=='c'-'a')) check[i] = 0;
            }

            System.out.println(max);
        }

    }
}
