package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1774 {

    public static class Ufo implements Comparable<Ufo>{
        int v;
        double w;

        public Ufo(int v, double w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Ufo o){
            return Double.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ufoLoca = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ufoLoca[i][0] = x;
            ufoLoca[i][1] = y;
        }

        List<List<Ufo>> edgeList = new ArrayList<>(); // Ufo 간선 리스트
        List<List<Integer>> connected = new ArrayList<>(); // 이미 연결된 간선 번호
        for(int i=0;i<N;i++){
            edgeList.add(new ArrayList<>());
            connected.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken())-1;
            int v2 = Integer.parseInt(st.nextToken())-1;

            connected.get(v1).add(v2);
            connected.get(v2).add(v1);

            // 이미 연결된 간선의 가중치를 0으로 둠
            edgeList.get(v1).add(new Ufo(v2,0));
            edgeList.get(v2).add(new Ufo(v1,0));
        }


        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                // 이미 연결해서 간선의 가중치를 0으로 생성했다면 넘어가기
                if(connected.get(i).contains(j)) continue;

                double dist = Math.sqrt(Math.pow(ufoLoca[i][0] - ufoLoca[j][0], 2) + Math.pow(ufoLoca[i][1] - ufoLoca[j][1], 2));
                edgeList.get(i).add(new Ufo(j, dist));
                edgeList.get(j).add(new Ufo(i, dist));
            }
        }


        boolean[] visited = new boolean[N];
        double[] minDistArr = new double[N];
        double minCostSum = 0;
        Arrays.fill(minDistArr, Integer.MAX_VALUE);

        PriorityQueue<Ufo> pq = new PriorityQueue<>();
        pq.add(new Ufo(0,0));

        while(!pq.isEmpty()){
            Ufo u1 = pq.poll();

            if(minDistArr[u1.v] < u1.w) continue;
            if(visited[u1.v]) continue;

            visited[u1.v] = true;
            minCostSum += u1.w;

            for(Ufo u2 : edgeList.get(u1.v)){
                if(minDistArr[u2.v] > u2.w && !visited[u2.v]){
                    pq.add(u2);
                    minDistArr[u2.v] = u2.w;
                }
            }
        }


        System.out.print(String.format("%.2f", minCostSum));

    }
}
