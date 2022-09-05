package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                sb.append("*");
            }
            for(int j=N-i;j>0;j--){
                sb.append("  ");
            }
            for(int j=1;j<=i;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=N-1;i>0;i--){
            for(int j=i;j>0;j--){
                sb.append("*");
            }
            for(int j=i;j<N;j++){
                sb.append("  ");
            }
            for(int j=i;j>0;j--){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
