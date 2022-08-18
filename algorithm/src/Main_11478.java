import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<str.length();i++){
            for(int j=0;j<str.length();j++){
                if(i+j <= str.length())
                    set.add(str.substring(j,i+j));
            }
        }

        System.out.println(set.size());
    }
}
