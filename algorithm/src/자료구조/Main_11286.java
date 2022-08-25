package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2) == 0 ? o1 - o2 : Math.abs(o1) - Math.abs(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        while(N-->0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                sb.append((pq.isEmpty() ? 0 : pq.poll())+"\n");
            }else{
                pq.add(x);
            }
        }

        System.out.print(sb);
    }
}
