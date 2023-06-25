package programmers.문자열.JadenCase문자열만들기;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] words = s.split(" ");
        for(String word : words){
            if(!Character.isLetter(word.charAt(0))){
                String tmp = word.substring(1,word.length());
                sb.append(word.charAt(0)).append(tmp.toLowerCase()).append(" ");
            }
            else{
                String tmp = word.substring(1,word.length());
                sb.append(Character.toUpperCase(word.charAt(0))).append(tmp.toLowerCase()).append(" ");
            }
        }

        return sb.toString();
    }
}
