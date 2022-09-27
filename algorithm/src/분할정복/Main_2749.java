package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2749 {
    // 피사노 주기 공식
    // 피보나치 수를 M으로 나눴을 때 주기 P는
    // P = 15 * 10^(logM -1)
    // M이 1,000,000 이기 때문에 대입하면 P = 1,500,000
    static int[] dp = new int[1500000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        dp[1] = 1;
        System.out.println(divide((int)(n%1500000)));

    }

    public static int divide(int n){
        if(n == 0 ) return 0;
        if(dp[n] == 0) return dp[n] = (divide(n-1)+ divide(n-2)) % 1000000;
        else return dp[n];
    }
}
