package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17401 {

    public static void print(long[][] a){
        System.out.println("---------------------");
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(a[i][j]+" " );
            }
            System.out.println();
        }
        System.out.println();
    }
    public static long[][] mul(long[][] a, long[][] b){
        long [][] temp = new long[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    temp[i][j] += a[i][k]*b[k][j];
                    temp[i][j] %= 1000000007;
                }
            }
        }

        return temp;
    }
    static int N, D;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        long[][][] matList = new long[T][N][N];

        for(int t=0;t<T;t++){
            long[][] temp = new long[N][N];
            int M = Integer.parseInt(br.readLine());

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                temp[a][b] = c;
            }

            matList[t] = temp;
        }

        cnt = 0;
        int t = D / T;
        int r = D % T;

        long[][] ans = new long[N][N];

        for(int i=0;i<N;i++){
            ans[i][i] = 1;
        }

        for(int i=0;i<T;i++){
            ans = mul(ans, matList[i]);
        }

        ans = powMat(ans, t);

        for(int i=0;i<r;i++){
            ans = mul(ans, matList[i]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(ans[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

    public static long[][] powMat(long[][] a, int n){

        long[][] temp = new  long[N][N];
        if(n==0){
            for(int i=0;i<N;i++){
                temp[i][i] = 1;
            }
            return temp;
        }

        if(n==1){
            return a;
        }
        temp = powMat(a, n/2);
        temp = mul(temp, temp);
        if(n % 2== 1){
            temp = mul(temp, a);
        }
        return temp;
    }
}