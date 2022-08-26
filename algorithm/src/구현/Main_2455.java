package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int answer = 0;
        for(int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int del = Integer.parseInt(st.nextToken());
            int add = Integer.parseInt(st.nextToken());

            sum += add - del;
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

    }
}
