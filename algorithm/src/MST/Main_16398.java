package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16398 {

    static class Edge{
        int a, b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

    }

    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        List<Edge> list = new ArrayList<>();



        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int w = Integer.parseInt(st.nextToken());
                if(i<j){
                    list.add(new Edge(i,j,w));
                }
            }
        }

        Collections.sort(list, (o1, o2) -> Integer.compare(o1.w, o2.w));

        long cost = 0;

        for(Edge edge : list){
            if(union(edge.a, edge.b)){
                cost += edge.w;
            }
        }

        System.out.println(cost);



    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] =find(parent[x]);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x<y){
            parent[x] = y;
            return true;
        }
        else if(x>y){
            parent[y] = x;
            return true;
        }
        return false;
    }
}
