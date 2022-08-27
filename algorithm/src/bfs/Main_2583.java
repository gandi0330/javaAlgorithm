package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;

            for(int r=y1;r<=y2;r++){
                for(int c=x1;c<=x2;c++){
                    map[r][c] = true;
                }
            }
        }

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        List<Integer> areas = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!map[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});

                    map[i][j] = true;
                    int size = 1;

                    while(!q.isEmpty()){
                        int[] data = q.poll();


                        for(int k=0;k<4;k++){
                            int nr = dr[k] + data[0];
                            int nc = dc[k] + data[1];

                            if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]) continue;
                            size++;
                            q.add(new int[]{nr, nc});
                            map[nr][nc] = true;

                        }
                    }

                    areas.add(size);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(areas);
        sb.append(areas.size()+"\n");

        for(int area : areas){
            sb.append(area+" ");
        }
        sb.append("\n");
        System.out.print(sb);



    }
}
