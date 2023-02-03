package sds_Algorithm.day02;

import java.util.Arrays;
import java.util.Comparator;

public class SortSample {
    public static void main(String[] args){

        //단순 정수(Integer) 비교
        Integer[] nums = {1,5,3,2,5};
        //System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        Arrays.sort(nums, new Comparator<Integer>() { //람다로 개선
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Arrays.sort(nums,Comparator.reverseOrder());


        //객체 비교
        Item[] items = new Item[5];
        items[0] = new Item(1,5);
        items[1] = new Item(2,3);
        items[2] = new Item(3,3);
        items[3] = new Item(4,2);
        items[4] = new Item(5,1);

        Arrays.sort(items, new Comparator<Item>() { //람다로 개선
            @Override
            public int compare(Item o1, Item o2) {
                //조건 두가지 합치는 방법
                int comp1 = o1.value2 - o2.value2;
                if(comp1 == 0){
                    return o2.value1-o1.value1;
                }
                else{
                    return comp1;
                }
            }
        });

        System.out.println(Arrays.toString(items));

        //comparable을 구현했으니
        Arrays.sort(items);
        System.out.println(Arrays.toString(items));
    }
}
class Item implements Comparable<Item>{
    int value1;
    int value2;

    public Item(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }

    @Override
    public int compareTo(Item o2) {
        //0일때 비교하는 조건도 추가 가능.
        return value1 - o2.value1;
    }
}