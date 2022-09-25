package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9184 {
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[101][101][101];

        StringBuilder sb =new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())+50;
            int b = Integer.parseInt(st.nextToken())+50;
            int c = Integer.parseInt(st.nextToken())+50;

            if(a==49 && b == 49 && c == 49) break;


            sb.append("w("+(a-50)+", "+(b-50)+", "+(c-50)+") = "+recur(a,b,c)+"\n");

        }
        System.out.print(sb);
    }

    public static int recur(int a, int b, int c){
        if(dp[a][b][c] != 0) return dp[a][b][c];
        if(a <=50 || b<=50||c<=50){
            dp[a][b][c] = 1;
            return 1;
        }
        if(a>70||b>70||c>70){
            int cal = recur(70,70,70);
            dp[a][b][c] = cal;
            return cal;
        }

        if(a<b && b<c){
            int cal = recur(a,b,c-1)+ recur(a,b-1,c-1) - recur(a,b-1,c);
            dp[a][b][c] = cal;
            return cal;
        }

        int cal = recur(a-1,b,c)+recur(a-1,b-1,c)+recur(a-1,b,c-1)-recur(a-1,b-1,c-1);
        dp[a][b][c] = cal;
        return cal;

    }
}
