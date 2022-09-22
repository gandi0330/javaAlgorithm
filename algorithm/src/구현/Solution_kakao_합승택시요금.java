package 구현;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_kakao_합승택시요금 {
    public static void main(String[] args) {
        System.out.println(solution(6,4,6,2,new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
    }


    static class Node{
        int n, w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {

        // 초기화
        int[][] mat = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                mat[i][j] = 100000000;
            }
        }

        for(int i=0;i<fares.length;i++){
            mat[fares[i][0]][fares[i][1]] = fares[i][2];
            mat[fares[i][1]][fares[i][0]] = fares[i][2];
        }



        // 플로이드 워셜
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                if(k==i) continue;
                for(int j=1;j<=n;j++){
                    if(j==k || i==j) continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            minCost = Math.min(mat[i][a] + mat[i][b] + mat[i][s], minCost);
        }


        return minCost;
    }
}
