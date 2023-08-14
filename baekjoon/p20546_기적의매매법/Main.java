package baekjoon.p20546_기적의매매법;

import java.io.*;
import java.util.*;

public class Main {
    static int[] stockPrices, remainMoney, ownStockCount;
    static final String JUNHYUN_WIN = "BNP";
    static final String SUNGMIN_WIN = "TIMING";
    static final String DRAW = "SAMESAME";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalMoney = Integer.parseInt(br.readLine());
        stockPrices = new int[15]; //1-14
        remainMoney = new int[]{totalMoney, totalMoney}; //0 - 준현, 1- 성민
        ownStockCount = new int[2];

        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=14; i++){
            stockPrices[i] = Integer.parseInt(st.nextToken());
        }

        for(int day=1; day<=14; day++){
            //준현
            if (remainMoney[0] >= stockPrices[day]){
                ownStockCount[0] += remainMoney[0] / stockPrices[day];
                remainMoney[0] = remainMoney[0] % stockPrices[day];
            }

            //성민
            if(day >= 4){
                //하락세 -> 매수
                if(isBuying(day)){
                    if(remainMoney[1] >= stockPrices[day]){
                        ownStockCount[1] += (remainMoney[1] / stockPrices[day]);
                        remainMoney[1] = remainMoney[1] % stockPrices[day];
                    }
                }

                //상승세 -> 매도
                if (isSelling(day)) {
                    remainMoney[1] += ownStockCount[1] * stockPrices[day];
                    ownStockCount[1] = 0;
                }
            }
        }
        System.out.println(getWinner());
        br.close();
    }
    private static String getWinner(){
        long junhyun = remainMoney[0] + (stockPrices[14] * ownStockCount[0]);
        long sungmin = remainMoney[1] + (stockPrices[14] * ownStockCount[1]);
        if(junhyun > sungmin){
            return JUNHYUN_WIN;
        }
        else if(junhyun < sungmin){
            return SUNGMIN_WIN;
        }
        else{
            return DRAW;
        }
    }
    private static boolean isBuying(int day){ //매수
        return stockPrices[day-1] < stockPrices[day-2] && stockPrices[day-2] < stockPrices[day-3];
    }
    private static boolean isSelling(int day){ //매도
        return stockPrices[day-1] > stockPrices[day-2] && stockPrices[day-2] > stockPrices[day-3];
    }
}
