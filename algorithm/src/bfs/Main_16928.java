package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16928 {
    static class Node{
        int n, cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> moveMap = new HashMap<>();
        for(int i=0;i<N+M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            moveMap.put(x,y);
        }

        int[] visited = new int[101];
        Arrays.fill(visited,101);
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0));

        int answer = 101;

        while(!q.isEmpty()){
            Node node = q.poll();
            if(visited[node.n] < node.cnt) continue;
            if(node.n >= 100){
                answer = node.cnt;
                break;
            }

            for(int i=1;i<=6;i++){
                if(moveMap.containsKey(node.n+i)){
                    if(visited[moveMap.get(node.n+i)] <= node.cnt+1) continue;
                    visited[moveMap.get(node.n+i)] = node.cnt+1;
                    q.add(new Node(moveMap.get(node.n+i), node.cnt+1));
                }else{
                    if(node.n+i <= 100 &&visited[node.n+i] <= node.cnt+1) continue;
                    visited[node.n+i > 100 ? 100 : node.n+i] = node.cnt+1;
                    q.add(new Node(node.n+i, node.cnt+1));
                }
            }
        }

        System.out.println(answer);


    }
}
