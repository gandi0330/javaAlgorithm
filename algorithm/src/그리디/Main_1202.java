package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1202 {
    static class Jewelry{
        int m, v;

        public Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1,o2)->o1.m-o2.m);

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            pq.add(new Jewelry(m,v));
        }


        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for(int i=0;i<K;i++){
            bags.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Jewelry> weightPq = new PriorityQueue<>((o1,o2)->o2.v-o1.v);
        long answer = 0;
        while(!bags.isEmpty()){
            int m = bags.poll();
            while(!pq.isEmpty() && pq.peek().m <= m){
                Jewelry j = pq.poll();
                weightPq.add(j);
            }

            if(!weightPq.isEmpty()){
                answer += weightPq.poll().v;
            }
        }

        System.out.println(answer);

    }

}
