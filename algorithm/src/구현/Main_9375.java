package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();


                map.put(type,map.getOrDefault(type,1)+1);
            }

            int answer = 1;
            for(int num : map.values()){
                answer*=num;
            }

            System.out.println(answer-1);

        }
    }
}
