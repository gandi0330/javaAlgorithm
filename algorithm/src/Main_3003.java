import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] correctSet = {1,1,2,2,2,8};

        int[] answerSet = new int[6];

        for(int i=0;i<6;i++){
            answerSet[i] = correctSet[i] - Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<6;i++){
            sb.append(answerSet[i]+" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }
}
