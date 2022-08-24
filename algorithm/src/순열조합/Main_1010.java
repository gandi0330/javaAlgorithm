package 순열조합;

import java.io.*;
import java.util.StringTokenizer;

// 단순히 순열과 조합 경우의 수를 구할 땐 파스칼 삼각형을 사용
// dp로 저장
public class Main_1010 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            dp = new int[M+1][N+1];
            sb.append(combi(M,N)+"\n");
        }

        System.out.println(sb);
    }

    public static int combi(int n, int r){
        if(dp[n][r] != 0)
            return dp[n][r];
        if(r==0 || r==n){
            dp[n][r] = 1;
            return dp[n][r];
        }

        dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
        return dp[n][r];
    }
}
