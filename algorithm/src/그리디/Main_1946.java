package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1946 {

    public static class People implements Comparable<People>{
        int score1;
        int score2;

        People(int score1, int score2){
            this.score1 = score1;
            this.score2 = score2;
        }

        @Override
        public int compareTo(People o) {
            return this.score1 - o.score1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int passCnt = 0;
            PriorityQueue<People> peoples = new PriorityQueue<>();
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                peoples.add(new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            int scoreMin = peoples.poll().score2;
            passCnt++;

            while(!peoples.isEmpty()){
                People people = peoples.poll();
                if(people.score2 < scoreMin){
                    scoreMin = people.score2;
                    passCnt++;
                }
            }

            sb.append(passCnt+"\n");
        }
        System.out.print(sb);

    }


}
