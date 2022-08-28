package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());

        int cnt = 0;

        for(int i=1;i<Integer.MAX_VALUE;i++){
            cnt++;
            N-= i;
            if(N<0) break;
        }

        System.out.println(cnt-1);
    }
}
