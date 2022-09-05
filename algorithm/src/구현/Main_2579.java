package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num[] = new int[301];
        int dp[] = new int[301];

        for(int i=1;i<=n;i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = num[1];
        dp[2] = num[1]+num[2];
        dp[3] = Math.max(num[1] + num[3], num[2] + num[3]);

        for(int i=4;i<=n;i++){
            dp[i] = Math.max(num[i] + dp[i-2], num[i] + num[i-1] + dp[i-3]);

        }

        System.out.println(dp[n]);


    }
}
