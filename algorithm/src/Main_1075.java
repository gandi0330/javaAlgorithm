import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = (Integer.parseInt(br.readLine())/100)*100;
        int f = Integer.parseInt(br.readLine());

        int answer = 0;
        while(true){
            if((n+answer)%f != 0){
                answer++;
            }else break;
        }

        System.out.printf("%02d",(answer+n)%100);
    }
}
