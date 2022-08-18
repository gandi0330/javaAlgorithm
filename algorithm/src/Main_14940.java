import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] answer = new int[N][M];

        for(int i=0;i<N;i++){
            Arrays.fill(answer[i], -1);
        }

        int targetR = -1;
        int targetC = -1;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    targetR = i;
                    targetC = j;
                }

                if(map[i][j] == 0){
                    answer[i][j] = 0;
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        visited[targetR][targetC] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(targetR, targetC, 0));

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        answer[targetR][targetC] = 0;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0;i<4;i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || map[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                answer[nr][nc] = p.d + 1;
                q.add(new Point(nr,nc,p.d+1));
            }
        }

        StringBuilder sb =  new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(answer[i][j] + " ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static class Point{
        int r;
        int c;
        int d;

        Point(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
