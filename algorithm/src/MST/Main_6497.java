package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_6497 {
    public static class Light{
        int num;
        int cost;

        Light(int n, int cost){
            this.num = n;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        // ==================== 입력 =========================
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken()); // 집의 수
            int n = Integer.parseInt(st.nextToken()); // 길의 수

            if(m == 0 && n == 0) break;

            List<List<Light>> edgeList = new ArrayList<>();
            for(int i=0;i<m;i++){
                edgeList.add(new ArrayList<>());
            }

            int maxCostSum = 0;
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                maxCostSum += z;
                edgeList.get(x).add(new Light(y,z));
                edgeList.get(y).add(new Light(x,z));
            }

            // ====================== 로직 ========================

            int minCostSum = 0;
            int start = 0;
            int[] minDistArr = new int[m];
            boolean[] visited = new boolean[n];
            Arrays.fill(minDistArr, Integer.MAX_VALUE);
            minDistArr[start] = 0;

            for(int i=0;i<m;i++){
                int minVertex = 0;
                int minDist = Integer.MAX_VALUE;
                for(int j=0;j<m;j++){
                    if(!visited[j] && minDist > minDistArr[j]){
                        minDist = minDistArr[j];
                        minVertex = j;
                    }
                }

                minCostSum += minDistArr[minVertex];
                visited[minVertex] = true;

                for(Light light : edgeList.get(minVertex)){
                    if(!visited[light.num] && minDistArr[light.num] > light.cost){
                        minDistArr[light.num] = light.cost;
                    }
                }
            }

           sb.append(maxCostSum - minCostSum + "\n");
        }
        System.out.print(sb);
    }

}
