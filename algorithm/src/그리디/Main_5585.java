package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());

        int cnt = 0;

        while(N>0){
            if(N >= 500) N -= 500;
            else if(N >= 100 ) N -= 100;
            else if(N >= 50 ) N -= 50;
            else if(N >= 10 ) N -= 10;
            else if(N >= 5 ) N -= 5;
            else if(N >= 1 ) N -= 1;
            cnt++;
        }

        System.out.println(cnt);

    }
}
