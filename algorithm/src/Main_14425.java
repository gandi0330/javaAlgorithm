import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        HashMap<String, Boolean> map = new HashMap<>();

        for(int i=0;i<N;i++){
            map.put(br.readLine(), true);
        }

        for(int i=0;i<M;i++){
            if(map.containsKey(br.readLine()))
                answer++;
        }

        System.out.println(answer);

    }
}
