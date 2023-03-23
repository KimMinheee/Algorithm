package swea.D1.p2058_자릿수더하기;

import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;

        while(num != 0){
            sum += num%10;
            num = num/10;
        }
        System.out.println(sum);

    }
}