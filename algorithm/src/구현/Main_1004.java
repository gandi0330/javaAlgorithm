package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            int[][] planets = new int[n][3];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<3;j++){
                    planets[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Set<Integer> set = new HashSet<>();

            for(int i=0;i<n;i++){
                if(Math.sqrt(Math.pow(planets[i][0]-x1,2) + Math.pow(planets[i][1] - y1,2)) <= planets[i][2]){
                    set.add(i);
                }
            }

            for(int i=0;i<n;i++){
                if(Math.sqrt(Math.pow(planets[i][0]-x2,2) + Math.pow(planets[i][1] - y2,2)) <= planets[i][2]){
                    if(set.contains(i)) set.remove(i);
                    else set.add(i);
                }
            }
            sb.append(set.size()+"\n");
        }

        System.out.println(sb);

    }
}
