package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean visited[][] = new boolean[N+1][N+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            int start = q.poll();

            sb.append("a"+start+" ");
            for(int i=1;i<=N;i++){
                if(i!= start && !visited[start][i] && !(start == N && i == 1)){
                    visited[start][i] = true;
                    visited[i][start] = true;
                    q.add(i);
                    break;
                }
            }
        }
        sb.append("a1");
        System.out.println(sb);


    }
}
