package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        // temp * mat^n = Fn+1, Fn
        System.out.println(divide(n)[0][1]);

    }

    public static long[][] matMul(long[][] mat1, long[][] mat2){
        long[][] temp = new long[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    temp[i][j] += mat1[i][k] * mat2[k][j];
                    temp[i][j] %= 1000000007;
                }
            }
        }
        return temp;
    }

    public static long[][] divide(long n){
        if(n == 0) return new long[][]{{1,0},{0,1}};
        else if (n==1) return new long[][]{{0,1},{1,1}};
        long[][] temp = divide(n/2);
        temp = matMul(temp,temp);
        if(n%2 == 1){
            temp = matMul(temp, new long[][]{{0,1},{1,1}});
        }
        return temp;
    }
}
