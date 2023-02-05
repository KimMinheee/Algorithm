package baekjoon.p1713_후보추천하기;

import java.util.*;

//Person 객체 배열 생성시 학생번호 1~100까지 생성.
//액자틀은 ArrayList로 생성 -> b, arraylist 특성상 앞에서 삭제되기 보다는 뒤에서 삭제될 수 있도록 정렬하기(cnt내림차순 -> timestamp 내림차순)
//Person 객채 배열을 만듦으로써 학생번호를 하나씩 입력받을때마다 존재하는지 돌지 않아도 됨. -> person객체 배열에서 isIn 필드 확인하면 된다.
public class Solution {
    static int N,K;
    static int[] inputs;
    static Person[] person;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        inputs = new int[K];
        person = new Person[101]; //학생은 1~100까지 존재.

        List<Person> list = new ArrayList<>();
        for(int i=0; i<K; i++){
            int num = sc.nextInt();
            if(person[num] == null){
                person[num] = new Person(num,0,0,false);
            }

            if(person[num].isIn == true){
                person[num].count++;
            }
            else{//액자에 들어가있지 않은 경우.
                if(list.size() == N){
                    Collections.sort(list);
                    Person removeTarget = list.remove(N-1);
                    removeTarget.isIn = false;
                    removeTarget.count = 0;
                }
                person[num].count =1;
                person[num].isIn = true;
                person[num].timeStamp = i;
                list.add(person[num]);
            }
            Collections.sort(list, Comparator.comparingInt(o -> o.num));
        }
        for(Person p : list){
            System.out.print(p.num+" ");
        }
    }
}
class Person implements Comparable<Person>{
    int num;
    int count;
    int timeStamp;
    boolean isIn;

    public Person(int num, int count, int timeStamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    //arrayList 특성상 뒤에서 빼도록
    @Override
    public int compareTo(Person o2) {
        int comp1 = o2.count - count;
        if(comp1 == 0){
            return o2.timeStamp - timeStamp;
        }
        return comp1;
    }
}
