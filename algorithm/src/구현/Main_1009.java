package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Integer>[] mapper = new List[10];
        mapper[0] = new ArrayList<>(Arrays.asList(10));
        mapper[1] = new ArrayList<>(Arrays.asList(1));
        mapper[2] = new ArrayList<>(Arrays.asList(6,2,4,8));
        mapper[3] = new ArrayList<>(Arrays.asList(1,3,9,7));
        mapper[4] = new ArrayList<>(Arrays.asList(6,4));
        mapper[5] = new ArrayList<>(Arrays.asList(5));
        mapper[6] = new ArrayList<>(Arrays.asList(6));
        mapper[7] = new ArrayList<>(Arrays.asList(1,7,9,3));
        mapper[8] = new ArrayList<>(Arrays.asList(6,8,4,2));
        mapper[9] = new ArrayList<>(Arrays.asList(1,9));


        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) % 10;
            int b = Integer.parseInt(st.nextToken()) % mapper[a].size();

            sb.append(mapper[a].get(b)+"\n");
        }

        System.out.print(sb);

    }
}
