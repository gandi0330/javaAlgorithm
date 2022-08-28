package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq =new PriorityQueue<>();
        pq.add(64);
        int sum = 64;

        while(X!=sum){
            int minStick = (int)pq.poll();
            if(sum - minStick/2 >= X){
                sum -= minStick/2;
                pq.add(minStick/2);
            }else {
                pq.add(minStick/2);
                pq.add(minStick/2);
            }
        }

        System.out.println(pq.size());
    }
}
