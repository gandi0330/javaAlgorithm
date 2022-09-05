package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb =  new StringBuilder();
        for(int tc=0;tc<N;tc++){
            sb.append(br.readLine().matches("(100+1+|01)+") ? "YES" : "NO");
            sb.append("\n");

        }
        System.out.println(sb);
    }


}
