package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13460 {
    public static class Point{
        int r, c;

        public Point(){};
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void permu(int cnt, int target){
        if(cnt == target){
            go(permuArr);
            return;
        }

        for(int i=0;i<4;i++){
            permuArr[cnt] = i;
            permu(cnt+1, target);
        }
    }

    // 동 남 서 북
    static int dr[] = {0,1,0,-1};
    static int dc[] = {1,0,-1,0};
    static int permuArr[];
    static Point red, blue, hole;
    static int answer;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] =='R') red = new Point(i,j);
                else if(map[i][j] =='B') blue = new Point(i,j);
                else if(map[i][j] =='O') hole = new Point(i,j);
            }
        }

        permuArr = new int[10];
        answer = 11;

        permu(0,10);

        if(answer == 11) System.out.println(-1);
        else System.out.println(answer);
    }

    public static void go(int[] permuArr){

        int cnt = 0;
        Point redTemp = new Point(red.r, red.c);
        Point blueTemp = new Point(blue.r, blue.c);
        for(int d : permuArr){

            Point redPre = new Point(redTemp.r, redTemp.c);
            Point bluePre =  new Point(blueTemp.r, blueTemp.c);
            cnt++;
            if(answer <= cnt) break;

            while(true){


                int nextRedR = redTemp.r + dr[d];
                int nextRedC = redTemp.c + dc[d];

                if(map[nextRedR][nextRedC] =='#') break;

                redTemp.r = nextRedR;
                redTemp.c = nextRedC;

                if(map[nextRedR][nextRedC] =='O') {
                    break;
                }

            }
            while(true){
                int nextBlueR = blueTemp.r + dr[d];
                int nextBlueC = blueTemp.c + dc[d];

                if(map[nextBlueR][nextBlueC] =='#') break;


                blueTemp.r = nextBlueR;
                blueTemp.c = nextBlueC;

                if(map[nextBlueR][nextBlueC] =='O'){
                    break;
                }
            }
            if(redTemp.r == blueTemp.r && redTemp.c == blueTemp.c){
                if(redTemp.r == hole.r && redTemp.c == hole.c){
                    break;
                }
                if(d == 0){
                    if(redPre.c < bluePre.c)redTemp.c -= 1;
                    else blueTemp.c -= 1;
                }else if(d == 1){
                    if(redPre.r < bluePre.r) redTemp.r-=1;
                    else blueTemp.r-=1;
                }else if(d == 2){
                    if(redPre.c < bluePre.c) blueTemp.c+=1;
                    else redTemp.c += 1;
                }else if(d == 3){
                    if(redPre.r < bluePre.r) blueTemp.r+=1;
                    else redTemp.r+=1;
                }
            }

            if(redTemp.r == hole.r && redTemp.c == hole.c){
                answer = answer > cnt ? cnt : answer;
                break;
            }

            if(blueTemp.r == hole.r && blueTemp.c == hole.c){
                break;
            }
        }
    }




}
