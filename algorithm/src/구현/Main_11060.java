package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1001);
        dp[0] = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<=num[i];j++){
                if(i+j < N)
                    if(dp[i+j] > dp[i]+1)
                        dp[i+j] = dp[i]+1;
            }
        }

        if(dp[N-1] == 1001) System.out.println(-1);
        else System.out.println(dp[N-1]);

    }
}
