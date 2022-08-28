package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=N-1;j>i;j--){
                sb.append(" ");
            }
            for(int j=0;j<=i;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=N-1;i>0;i--){
            for(int j=N-1;j>=i;j--){
                sb.append(" ");
            }
            for(int j=0;j<i;j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
