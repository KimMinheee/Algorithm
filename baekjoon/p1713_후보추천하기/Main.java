package baekjoon.p1713_후보추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 개선할 점 :
 * 1. ArrayList 정렬 기준 바꿔서 맨 앞이 아니라 뒤 부터 삭제될 수 있도록 해서 시간 줄이기
 * 2. 35번 라인에서 i==0으로 분기처리한 거 안깔끔한 거 같음. 그냥 함수처리로 묶기.
 */
public class Main {
    static int N,M;
    static Integer[] recs;
    static List<People> frames = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        recs = new Integer[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            recs[i] = Integer.parseInt(st.nextToken());
        }

        sort();
    }
    static void sort(){
        int timeStamp = 0;
        for(int i=0; i<M; i++){ //총 m번의 추천
            timeStamp+=1;
            if(i==0){
                frames.add(new People(recs[i],timeStamp,1,true));
            }
            else {
                int finalI = i;
                //데이터가 존재하는 경우.
                int findIdx = isInFrame(recs[finalI]);
                if(findIdx!=-1){
                    frames.get(findIdx).cnt +=1;
                    //frames.get(findIdx).timeStamp = timeStamp;
                }
                //데이터가 존재하지 않는 경우 -> 기존 거 갱신 & 앨범에서 삭제 & 앨범에 신규추천 다시 넣기.
                else {
                    Collections.sort(frames, new Comparator<People>() {
                        @Override
                        public int compare(People o1, People o2) {
                            int tmp = o1.cnt - o2.cnt;
                            if (tmp == 0) {
                                return o1.timeStamp - o2.timeStamp;
                            } else {
                                return tmp;
                            }
                        }
                    });

                    if(frames.size()>=N){
                        //꽉찬 경우
                        frames.get(0).cnt = 0;
                        frames.get(0).isIn = false;
                        frames.set(0,new People(recs[finalI], timeStamp, 1, true));
                    }
                    else{
                        //여유 있는 경우
                        frames.add(new People(recs[finalI], timeStamp, 1, true));
                    }
                }
            }
        }


        Collections.sort(frames,Comparator.comparingInt(People::getData));
        StringBuilder sb = new StringBuilder();
        //출력
        for(People p : frames){
            sb.append(p.data+" ");
        }
        System.out.println(sb.toString());
    }

    static int isInFrame(int rec){
        int findIdx = -1;
        for(int i=0; i<frames.size(); i++){
            if(frames.get(i).data == rec){
                findIdx = i;
                break;
            }
        }
        return findIdx;
    }
}
class People{
    int data;

    public int getData() {
        return data;
    }

    public People(int data, int timeStamp, int cnt, boolean isIn) {
        this.data = data;
        this.timeStamp = timeStamp;
        this.cnt = cnt;
        this.isIn = isIn;
    }

    int timeStamp; //들어온 순서
    int cnt; // 횟수
    boolean isIn;//현재 액자에 들어와있는지 여부

}
