package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        TreeMap<String, Integer> mapper = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        while(true){
            cnt++;
            mapper.put(str, mapper.getOrDefault(str, 0)+1);

            str = br.readLine();
            if(str == null || str.length()==0) break;

        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : mapper.entrySet()){
            sb.append(entry.getKey()+" "+String.format("%.4f", entry.getValue()*100.0/cnt) + "\n");
        }

        System.out.print(sb.toString());

    }
}
