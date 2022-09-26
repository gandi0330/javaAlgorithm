import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Integer> pq  = new PriorityQueue<>();
            for(int i=0;i<k;i++){
                pq.add(Integer.parseInt(st.nextToken()));
            }

            int sum = 0;
            while(!pq.isEmpty()){
                int cost1 = pq.poll();
                if(pq.isEmpty()){
                    break;
                }else{
                    int cost2 = pq.poll();
                    int costSum = cost1 + cost2;
                    sum += costSum;
                    pq.add(costSum);
                }
            }
            System.out.println(sum);
        }

    }
}
