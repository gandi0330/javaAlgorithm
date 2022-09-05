package 구현;

import java.io.*;

public class Main_2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            for(int j=0;j<N-i;j++){
                sb.append(" ");
            }
            sb.append("*");
            for(int j=1;j<i;j++){
                sb.append("**");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
