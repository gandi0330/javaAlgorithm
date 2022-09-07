package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;
        int score = 0;

        for(int i=1;i<=5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j=0;j<4;j++){
                sum+= Integer.parseInt(st.nextToken());
            }
            if(sum > score){
                n = i;
                score = sum;
            }
        }

        System.out.println(n+" " + score);

    }
}
