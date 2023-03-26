package baekjoon.p1446_지름길;
import java.util.*;
import java.io.*;

public class Main {
    static int N,D;
    static List<List<Info>> data = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int i=0; i<=D; i++){
            data.add(i, new ArrayList<Info>());
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());


            if(start>dest) continue; //시작점이 도착점보다 클 경우
            else if(dest-start < length) continue; //지름길이 더 길 경우
            else if(dest > D) continue; //도착지점보다 더 큰 경우
            else{
                data.get(dest).add(new Info(start,length));
            }
        }

        System.out.println(getShortestWay());
        br.close();
    }
    static int getShortestWay(){
        /**
         * 1. 거리 배열 만들기
         * 2. 거리 배열 0을 제외하고 다 무한대로 만들기
         * 3. 0부터 D까지 1씩 증가하며 확인한다.
         * 4. if(지름길이 있는 도착지점인가)
         * 4-1. 지름길이 있는 도착지점이라면
         * 5. 배열[시작지점]+ length < 배열[도착지점]
         * 5-1. 해당 도착지점을 Math.min(배열[도착지점-1]+1, 배열[시작지점]+length)값으로 설정한다.
         * 4-2.if(지름길이 없는 도착지점인가)
         * 5. 배열[도착지점] = 배열[도착지점-1]+1;
         * 6. D까지 포함해서 다 돌고 D에 들어있는 값을 출력한다.
         */
        int[] dist = new int[D+1]; //도착지점 D까지의 배열을 만든다.
        Arrays.fill(dist,INF);
        dist[0] = 0;

        for(int i=1; i<=D; i++){
            if(data.get(i).size()>0){ //지름길이 존재하는가?
                for(Info info : data.get(i)){
                    if(dist[i] > dist[info.start]+info.length){ //지름길이 여러개 존재하는 경우가 있어서 확인해줘야 함.
                        dist[i] = Math.min(dist[i-1]+1, dist[info.start]+info.length);
                    }
                }
            }
            else{
                //지름길이 존재하지 않는 경우
                dist[i] = dist[i-1]+1; //이전값 +1
            }
        }
        return dist[D];
    }
}
class Info implements Comparable<Info>{
    int start;
    int length;

    public Info(int start, int length){
        this.start = start;
        this.length = length;
    }

    @Override
    public int compareTo(Info i2){
        int startTmp = this.start - i2.start;
        int lengthTmp = this.length - i2.length;
        if(startTmp == 0){
            return lengthTmp;
        }
        return startTmp;
    }

}
