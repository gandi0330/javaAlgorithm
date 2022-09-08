package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_codeTree_collision_experiment_with_wall {

    public static class Marble{
        int r, c, dir;
        boolean exist;

        public Marble(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            exist = true;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N, M;
    static int marbleMat[][];
    static List<Marble> marbles;

    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,-1,0,1};

    public static void moveMarble(){
        for(Marble marble : marbles){
            if(!marble.exist) continue;
            int nr = marble.r + dr[marble.dir];
            int nc = marble.c + dc[marble.dir];

            if(nr<0||nr>=N||nc<0||nc>=N){
                marble.dir = (marble.dir + 2 )% 4;
            } else {
              marbleMat[marble.r][marble.c]--;
              marble.r = nr;
              marble.c = nc;
              marbleMat[marble.r][marble.c]++;
            }
        }
    }

    public static void checkMarble(){
        for(Marble marble : marbles){
            if(marbleMat[marble.r][marble.c] >= 2){
                marble.exist = false;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if (marbleMat[i][j] >= 2) marbleMat[i][j] = 0;
            }
        }

        for(int i=0;i<marbles.size();i++){
            if(!marbles.get(i).exist){
                marbles.remove(i--);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            marbleMat = new int[N][N];
            marbles = new ArrayList<>();
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken())-1;
                char dirChar = st.nextToken().charAt(0);
                int dir = -1;
                switch(dirChar){
                    case 'U' :
                        dir = 0;
                        break;
                    case 'L' :
                        dir = 1;
                        break;
                    case 'D' :
                        dir = 2;
                        break;
                    case 'R' :
                        dir = 3;
                        break;
                }

                marbles.add(new Marble(r,c,dir));
                marbleMat[r][c] = 1;
            }

            int t = N*2;
            while(t-->0){
                moveMarble();
                checkMarble();
            }

            int answer = 0;
            for(Marble marble : marbles){
                if(marble.exist) answer++;
            }
            System.out.println(answer);


        }
    }
}
