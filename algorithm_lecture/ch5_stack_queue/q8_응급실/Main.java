package algorithm_lecture.ch5_stack_queue.q8_응급실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static Queue<Patient> queue = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            int degree = Integer.parseInt(st.nextToken());
            max = Math.max(degree,max);
            queue.add(new Patient(degree,i));
        }

        int answer = 0;
        while(!queue.isEmpty()){
            Patient tmp = (Patient) queue.poll();
            for(Patient p : queue){
                if(p.dangerDegree>tmp.dangerDegree){
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                answer++;
                if (tmp.sequence == M) {
                    System.out.println(answer);
                    return;
                }
            }

        }
    }
}
class Patient{
    int dangerDegree;
    int sequence;
    public Patient(int dangerDegree, int sequence){
        this.dangerDegree = dangerDegree;
        this.sequence = sequence;
    }

}