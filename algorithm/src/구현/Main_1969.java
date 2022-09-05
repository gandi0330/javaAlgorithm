package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dnas = new String[N];
        for(int i=0;i<N;i++){
            dnas[i] = br.readLine();
        }

        String answerDna = "";
        int answerDist = 0;

        for(int i=0;i<M;i++){
            TreeMap<Character, Integer> mapper = new TreeMap<>();
            for(int j=0;j<N;j++){
                mapper.put(dnas[j].charAt(i), mapper.getOrDefault(dnas[j].charAt(i), 0)+1);
            }

            List<Map.Entry<Character, Integer>> list = new ArrayList<>(mapper.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
                }
            });

            answerDna += list.get(0).getKey();
            answerDist += N-list.get(0).getValue();
        }

        System.out.println(answerDna);
        System.out.println(answerDist);
    }




}
