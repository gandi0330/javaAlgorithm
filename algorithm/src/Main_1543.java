import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();

        int answer = 0;

        for(int i=0;i<=doc.length() - word.length();i++){
            if(word.equals(doc.substring(i,i+word.length()))){
                answer++;
                i+= word.length()-1;
            }
        }

        System.out.println(answer);

    }
}
