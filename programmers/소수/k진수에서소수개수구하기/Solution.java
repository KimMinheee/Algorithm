package programmers.소수.k진수에서소수개수구하기;

/*
1. k진수로 변환
2. "0" 기준으로 split
3. 끊은 단위를 소수인지 판별
*/

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String[] primeNums = Integer.toString(n,k).split("0");

        for(String primeNum : primeNums){
            if(primeNum.equals("")) continue;
            if(isPrime(primeNum)) answer++;
        }

        return answer;
    }
    static boolean isPrime(String data){
        long num = Long.parseLong(data);

        if(num <= 1) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;

    }

    //배열의 크기 넘어가서 틀리는 케이스 존재
    static boolean isPrime2(String data){
        long num = Long.parseLong(data);
        long[] arr = new long[(int)(num+1)];

        arr[0] = 1;
        arr[1] = 1;

        for(int i=2; i<Math.sqrt(num); i++){
            if(arr[i] == 0){
                // 소수의 배수들은 소수가 아니므로 false처리
                for(int j = i*2; j <= num; j+=i) {
                    arr[j] = 1;
                }
            }
        }
        return arr[(int)num] == 0;
    }
}
