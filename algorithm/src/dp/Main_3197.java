package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3197 {
    static int r, c;
    static int[][] mat;
    static int swan[] = {-1,-1};
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int[] parent;
    static int[] rank;
    static class Node{
        int r, c, t;

        public Node(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }


    public static void unionInit(){
        parent = new int[r*c];
        rank = new int[r*c];
        for(int i=0;i<r*c;i++){
            parent[i] = -1;
            rank[i] = 0;
        }
    }

    public static int find(int a){
        if(parent[a]< 0) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a == b) return;

        if(rank[a] < rank[b]){
            parent[a] = b;
        }else {
            parent[b] = a;

            if(rank[a] == rank[b])
                rank[a]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        unionInit();
        mat = new int[r][c];
        for(int i=0;i<r;i++){
            Arrays.fill(mat[i], -1);
        }

        for(int i=0;i<r;i++){
            String str = br.readLine();
            for(int j=0;j<c;j++){
                char ch = str.charAt(j);
                if(ch == 'L'){
                    if(swan[0] == -1) swan[0] = i*c+j;
                    else swan[1] = i*c+j;
                }
                if(ch != 'X') {
                    mat[i][j] = 0;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == -1) continue;

                boolean isCandidate = false;
                for(int k=0;k<4;k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr<0||nr>=r||nc<0||nc>=c) continue;
                    if(mat[nr][nc] != -1) union(i*c+j, nr*c+nc);
                    else isCandidate = true;
                }
                if(isCandidate) q.add(new Node(i,j,0));
            }
        }

        if(find(swan[0]) == find(swan[1])) System.out.println(0);
        else{
            loop : while(!q.isEmpty()){
                Node node = q.poll();

                for(int k=0;k<4;k++){
                    int nr = node.r + dr[k];
                    int nc = node.c + dc[k];
                    if(nr<0||nr>=r||nc<0||nc>=c) continue;
                    union(node.r*c+node.c, nr*c+nc);

                    if(find(swan[0]) == find(swan[1])) {
                        System.out.println(mat[nr][nc]);
                        break loop;
                    }

                    if(mat[nr][nc] == -1){
                        mat[nr][nc] = node.t+1;
                        q.add(new Node(nr,nc, node.t+1));
                    }
                }
            }
        }
    }
}
