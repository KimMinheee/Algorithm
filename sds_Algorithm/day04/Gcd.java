package sds_Algorithm.day04;

//(GCD)최대공약수 구하는 유클리드호제법
public class Gcd {
    public static void main(String[] args) {

    }
    static int gcd(int a, int b){
        //gcd(a,b) == gcd(b,a%b), a%b==0일때 b에 gcd값이 존재.
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
