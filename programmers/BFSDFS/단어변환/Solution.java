package programmers.BFSDFS.단어변환;

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int arrSize = words.length;

        boolean[] visited = new boolean[arrSize];

        //세팅
        Queue<Word> que = new LinkedList<>();
        char[] beginArr = begin.toCharArray();
        for(int i=0; i<arrSize; i++){
            char[] wordArr = words[i].toCharArray();
            if(isPossible(beginArr,wordArr)) {
                visited[i] = true;
                que.add(new Word(words[i],1));
            }
        }

        //반복
        while(!que.isEmpty()){
            Word tmp = que.poll();
            if(tmp.word.equals(target)) return tmp.count;

            beginArr = tmp.word.toCharArray();
            int count = tmp.count;

            for(int i=0; i<arrSize; i++){
                char[] wordArr = words[i].toCharArray();
                if(isPossible(beginArr,wordArr)){
                    if(visited[i] == false){
                        visited[i] = true;
                        que.add(new Word(words[i],count+1));
                    }
                }
            }

        }
        return 0;
    }
    boolean isPossible(char[] beginArr, char[] wordArr){
        int cnt = 0;
        for(int j=0; j<wordArr.length; j++){
            if(wordArr[j] == beginArr[j]) cnt++;
        }
        if(cnt == wordArr.length-1) {
            return true;
        }
        return false;
    }
}
class Word{
    String word;
    int count;

    public Word(String word, int count){
        this.word = word;
        this.count = count;
    }
}
