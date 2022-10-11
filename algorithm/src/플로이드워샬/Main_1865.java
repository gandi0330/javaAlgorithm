package 플로이드워샬;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            long[][] mat = new long[N][N];

            for(int i=0;i<N;i++){
                Arrays.fill(mat[i], Integer.MAX_VALUE);
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;
                int t = Integer.parseInt(st.nextToken());
                mat[s][e] = Math.min(mat[s][e], t);
                mat[e][s] = Math.min(mat[e][s], t);
            }

            for(int i=0;i<W;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;
                int t = Integer.parseInt(st.nextToken());
                mat[s][e] = -t;
            }

            boolean timeTravle = false;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int k=0;k<N;k++){
                        mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                        if(i==j && mat[i][j] < 0){
                            timeTravle = true;
                            break;
                        }
                    }
                }
            }


            if(timeTravle) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb);

    }
}
