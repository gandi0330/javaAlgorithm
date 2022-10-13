package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] indegree = new int[N+1];
        List<List<Integer>> edgeList = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edgeList.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k < 2) continue;
            int temp = Integer.parseInt(st.nextToken());
            for(int j=0;j<k-1;j++){
                int a = Integer.parseInt(st.nextToken());
                edgeList.get(temp).add(a);
                indegree[a]++;
                temp = a;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=N;i++){
           if(indegree[i] == 0) q.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int singer = q.poll();
            answer.add(singer);

            for(Integer temp : edgeList.get(singer)){
                indegree[temp]--;
                if(indegree[temp] ==0) q.add(temp);
            }
        }

        if(answer.size() != N) System.out.println(0);
        else {
            StringBuilder sb=  new StringBuilder();
            for(Integer temp : answer){
                sb.append(temp+"\n");
            }
            System.out.println(sb);
        }


    }
}
