package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Computer>> edgeList = new ArrayList<>();
        int[] minEdge = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++){
            edgeList.add(new ArrayList<>());
            minEdge[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList.get(a-1).add(new Computer(b-1,c));
            edgeList.get(b-1).add(new Computer(a-1,c));
        }

        int start = 0;
        minEdge[start] = 0;

        int answer = 0;

        for(int i=0;i<N;i++){
            int min = Integer.MAX_VALUE;
            int minVertex = 0;
            for(int j=0;j<N;j++){
                if(!visited[j] && min > minEdge[j]){
                    min = minEdge[j];
                    minVertex = j;
                }
            }

            visited[minVertex] = true;
            answer += min;

            for(Computer computer : edgeList.get(minVertex)){
                if(!visited[computer.n] && minEdge[computer.n] > computer.cost){
                    minEdge[computer.n] =  computer.cost;
                }
            }
        }

        System.out.println(answer);

    }

    public static class Computer implements  Comparable<Computer>{
        int cost;
        int n;

        Computer(int n, int cost){
            this.cost =cost;
            this.n = n;
        }

        @Override
        public int compareTo(Computer o) {
            return this.cost - o.cost;
        }
    }
}
