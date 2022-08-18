import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        // 물의 높이
        for(int h=0;h<=100;h++){
            boolean[][] visited = new boolean[N][N];
            int safezone = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] > h && !visited[i][j]){
                        Queue<Point> q = new LinkedList<>();
                        q.add(new Point(i,j));
                        visited[i][j] = true;

                        while(!q.isEmpty()){
                            Point p = q.poll();

                            for(int k=0;k<4;k++){
                                int nr = p.r + dr[k];
                                int nc = p.c + dc[k];

                                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] <= h) continue;
                                q.add(new Point(nr,nc));
                                visited[nr][nc] = true;
                            }
                        }

                        safezone++;
                    }
                }
            }

            if(safezone == 0) break;
            else if(safezone > answer) answer = safezone;

        }
        System.out.println(answer);
    }

    public static class Point{
        int r;
        int c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
