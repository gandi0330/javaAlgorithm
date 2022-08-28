package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<7;i++){
            int n = Integer.parseInt(br.readLine());

            if(n%2==1){
                sum+= n;
                min = min > n ? n : min;
            }
        }

        if(sum==0) System.out.println(-1);
        else {
            System.out.println(sum+"\n"+min);
        }


    }


}
