package 플로이드워샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] graph = new int[v+1][v+1];

        for(int i=1;i<=v;i++){
            for(int j=1;j<=v;j++){
                if(i==j) continue;
                graph[i][j] = 4000001;
            }
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        for(int k=1;k<=v;k++){
            for(int i=1;i<=v;i++){
                if(k==i) continue;
                for(int j=1;j<=v;j++){
                    if(i==k || k == j) continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int cost = 4000001;
        for(int i=1;i<=v;i++){
            for(int j=1;j<=v;j++){
                if(i==j) continue;
                cost = Math.min(cost, graph[i][j] + graph[j][i]);
            }
        }

        if(cost == 4000001) System.out.println(-1);
        else System.out.println(cost);

    }
}
