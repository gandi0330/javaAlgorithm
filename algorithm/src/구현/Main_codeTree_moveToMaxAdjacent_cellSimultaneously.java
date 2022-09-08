package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_codeTree_moveToMaxAdjacent_cellSimultaneously {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] mat = new int[n][n];
        int[][] marble = new int[n][n];
        int marbleCnt = m;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            marble[r][c] = 1;
        }

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        while(t-->0){

            int[][] nextMarble = new int[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(marble[i][j] == 1){
                        int max = 0;
                        int d = 0;
                        for(int k=0;k<4;k++){
                            int nr = i + dr[k];
                            int nc = j + dc[k];

                            if(nr<0 || nr>=n || nc<0 || nc>=n || max >= mat[nr][nc]) continue;
                            max = mat[nr][nc];
                            d = k;
                        }

                        nextMarble[i+dr[d]][j+dc[d]]++;
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(nextMarble[i][j] >= 2) {
                        marbleCnt-= nextMarble[i][j];
                        nextMarble[i][j] = 0;
                    }
                    marble[i][j] = nextMarble[i][j];
                }
            }
        }
        System.out.println(marbleCnt);
    }

}
