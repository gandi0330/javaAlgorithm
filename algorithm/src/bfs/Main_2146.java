package bfs;

import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146 {
    static class Node{
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Qnode{
        int r,c,dist;

        public Qnode(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int dr[] = {1,0,-1,0};
        int dc[] = {0,1,0,-1};
        int groupIdx = 1;
        boolean[][] visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && map[i][j] != 0){
                    visited[i][j] = true;
                    map[i][j] = groupIdx;
                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i,j));

                    while(!q.isEmpty()){
                        Node node = q.poll();

                        for(int k=0;k<4;k++){
                            int nr = node.r+dr[k];
                            int nc = node.c+dc[k];

                            if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc]==0||visited[nr][nc]) continue;
                            map[nr][nc] = groupIdx;
                            visited[nr][nc] = true;
                            q.add(new Node(nr,nc ));
                        }
                    }
                    groupIdx++;
                }
            }
        }

        int minDist = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=0){
                    boolean[][] visitedQ = new boolean[N][N];
                    Queue<Qnode> q = new LinkedList<>();
                    q.add(new Qnode(i,j,0));
                    visitedQ[i][j] = true;

                    while(!q.isEmpty()){
                        Qnode qnode = q.poll();

                        if(qnode.dist >= minDist) break;
                        for(int k=0;k<4;k++){
                            int nr = qnode.r + dr[k];
                            int nc = qnode.c + dc[k];
                            if(nr<0||nr>=N||nc<0||nc>=N||visitedQ[nr][nc]||map[i][j]==map[nr][nc]) continue;
                            visitedQ[nr][nc] = true;
                            if(map[nr][nc] == 0){
                                q.add(new Qnode(nr,nc,qnode.dist+1));
                            }else if(map[nr][nc] != 0){
                                minDist = Math.min(minDist, qnode.dist);
                            }
                        }
                    }


                }
            }
        }

        System.out.println(minDist);


    }
}
