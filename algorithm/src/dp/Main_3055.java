package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3055 {
    public static class Hedgehog{
        int r,c,t;

        public Hedgehog(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public static class Node{
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    static int R, C;
    static char[][] map;
    static Node D, S;
    static String str;
    static int[][] minTime;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static List<Node> waterNodes;

    public static void moveWater(){
        waterNodes = new ArrayList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] == '*'){
                    waterNodes.add(new Node(i,j));
                }
            }
        }

        for(Node water : waterNodes){

            for(int k=0;k<4;k++){
                int nr = water.r + dr[k];
                int nc = water.c + dc[k];

                if(nr<0||nr>=R||nc<0||nc>=C||map[nr][nc] == 'D' || map[nr][nc] == 'X') continue;
                map[nr][nc] = '*';
            }
        }
    }

    public static void moveS(){
        Queue<Hedgehog> q = new LinkedList<>();
        q.add(new Hedgehog(S.r,S.c,0));

        int wave = -1;
        while(!q.isEmpty()){

            Hedgehog tempS = q.poll();

            if(wave < tempS.t) {
                moveWater();
                wave = tempS.t;
            }

            for(int k=0;k<4;k++){
                int nr = tempS.r + dr[k];
                int nc = tempS.c + dc[k];

                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(map[nr][nc]=='*'||map[nr][nc]=='X') continue;
                if(minTime[nr][nc] <= tempS.t+1) continue;

                q.add(new Hedgehog(nr,nc,tempS.t+1));
                minTime[nr][nc] = tempS.t+1;
            }
        }

        if(minTime[D.r][D.c] == Integer.MAX_VALUE) System.out.println("KAKTUS");
        else System.out.println(minTime[D.r][D.c]);

    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0;i<R;i++){
            str = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'D') D = new Node(i,j);
                else if(map[i][j] == 'S') S = new Node(i,j);
            }
        }

        minTime = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }

        moveS();

   }
}
