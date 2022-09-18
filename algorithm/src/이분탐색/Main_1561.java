package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1561 {
    static int[] operTime;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st =  new StringTokenizer(br.readLine());
        operTime = new int[M];
        for(int i=0;i<M;i++){
            operTime[i] = Integer.parseInt(st.nextToken());
        }

        if(N <= M){
            System.out.println(N);
        }else{
            long t = upperBound();

            long children = calPeopleCnt(t-1);

            for(int i=0;i<M;i++){
                if(t % operTime[i] == 0){
                    children++;
                }
                if(children == N){
                    System.out.println(i+1);
                    break;
                }
            }
        }

    }

    public static long calPeopleCnt(long t){
        long sum = M;

        for(int oper : operTime){
            sum += t/oper;
        }

        return sum;
    }

    public static long upperBound(){
        long left = 1L;
        long right = 30 * 2000000000L;

        long t = -1;

        while(left <= right){
            long mid = (left+right)/2;

            if(calPeopleCnt(mid) >= N){
                t = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return t;
    }
}
