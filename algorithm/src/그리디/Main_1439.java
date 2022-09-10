package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int zeros = 0;
        int ones = 0;

        int index = 0;
        char sch = str.charAt(0);
        while(index < str.length()){
            if(sch != str.charAt(index)){
                if(sch == '0') {
                    zeros++;
                }else ones++;
                sch = str.charAt(index);
            };
            index++;
        }

        if(sch == '0') {
            zeros++;
        }else ones++;

//        System.out.println(zeros+ " " + ones);
        System.out.println(Math.min(zeros, ones));

    }
}
