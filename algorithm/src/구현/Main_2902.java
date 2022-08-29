package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strs = br.readLine();
        String answer = "";
        for(String str : strs.split("-")){
            answer+= str.charAt(0);
        }

        System.out.println(answer);



    }
}
