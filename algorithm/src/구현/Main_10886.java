package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cute = 0;
        for(int i=0;i<n;i++){
            if(br.readLine().equals("1")) cute++;
            else cute--;
        }

        if(cute > 0) System.out.println("Junhee is cute!");
        else System.out.println("Junhee is not cute!");

    }
}
