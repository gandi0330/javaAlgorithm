package 해쉬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();

            if(cmd.equals("enter")) set.add(name);
            else if(cmd.equals("leave")) set.remove(name);
        }

        StringBuilder sb = new StringBuilder();
        set.stream().forEach(o -> sb.append(o+"\n"));

        System.out.print(sb);

    }
}
