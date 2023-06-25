package programmers.문자열.JadenCase문자열만들기;


class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        boolean isFindLetterOrDigit = false;
        for (int i = 0; i < s.length(); i++) {
            //앞에서부터 돌면서 공백은 추가, 맨 처음 문자/숫자는 추가
            Character c = s.charAt(i);

            if (c == ' ') {
                sb.append(c);
                isFindLetterOrDigit = false;
            }
            //맨 처음 문자 or 숫자
            else if (Character.isLetterOrDigit(c) && !isFindLetterOrDigit) {
                isFindLetterOrDigit = true;
                if (Character.isLetter(c)) sb.append(Character.toUpperCase(c));
                if (Character.isDigit(c)) sb.append(c);
            } else if (Character.isLetter(c) && isFindLetterOrDigit) {
                sb.append(Character.toLowerCase(c));
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
