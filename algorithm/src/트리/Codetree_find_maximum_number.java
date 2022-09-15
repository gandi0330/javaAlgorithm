package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Codetree_find_maximum_number {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        for(int i=1;i<=m;i++){
            set.add(i);
        }

        StringBuilder sb = new StringBuilder();
        st=  new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            set.remove(Integer.parseInt(st.nextToken()));
            sb.append(set.last()+"\n");
        }

        System.out.print(sb);


    }
}
