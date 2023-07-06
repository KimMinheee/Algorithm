package programmers.해시.주차요금계산;

import java.util.*;

class Solution {
    static Map<String, Integer> parkingLot = new HashMap<>();
    static Map<String, Integer> fee = new TreeMap<>();
    static int defaultCost, defaultTime, unitCost, unitTime;

    public int[] solution(int[] fees, String[] records) {
        defaultTime = fees[0];
        defaultCost = fees[1];
        unitTime = fees[2];
        unitCost = fees[3];

        for (int i = 0; i < records.length; i++) {
            String[] splitRecord = records[i].split(" ");

            int time = getTime(splitRecord[0]);
            String num = splitRecord[1];
            String status = splitRecord[2];

            if (status.equals("IN")) {
                parkingLot.put(num, time);
            }
            if (status.equals("OUT")) {
                if (fee.containsKey(num)) {//이미 존재
                    fee.put(num, fee.get(num) + (time - parkingLot.get(num))); //기존꺼 계속 누적
                } else {
                    fee.put(num, time - parkingLot.get(num));
                }

                parkingLot.remove(num); //차 빼기(주차비 정산하고 뺌)
            }
        }

        //입차하고 나가지 않은 차 23:59 출차 처리
        for (String num : parkingLot.keySet()) {
            int out = getTime("23:59");

            if (fee.containsKey(num)) {
                fee.put(num, fee.get(num) + (out - parkingLot.get(num)));
            } else {
                fee.put(num, out - parkingLot.get(num));
            }
        }

        int idx = 0;
        int[] answer = new int[fee.size()];
        for (String car : fee.keySet()) {
            int cost = fee.get(car);

            if (cost <= defaultTime) {
                answer[idx] = defaultCost;
            } else {
                answer[idx] = (int) (defaultCost + Math.ceil((double) (cost - defaultTime) / unitTime) * unitCost);
            }
            idx++;
        }
        return answer;

    }

    public static int getTime(String time) {
        String[] splitTime = time.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);

        return (hour * 60) + minute;
    }
}
