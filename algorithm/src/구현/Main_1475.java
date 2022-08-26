package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int numCnt[] = new int[10];

        for(char c : num.toCharArray()){
            int n = c - '0';
            numCnt[n]++;
        }

        int answer = 0;

        for(int i=0;i<10;i++){
            if (i==6 || i==9){
                continue;
            }
            answer = Math.max(numCnt[i], answer);
        }

        if((numCnt[6] + numCnt[9]) % 2 == 0){
            answer = Math.max((numCnt[6]+numCnt[9])/2, answer);
        }else{
            answer = Math.max((numCnt[6]+numCnt[9])/2+1,answer);
        }

        System.out.println(answer);

    }
}
