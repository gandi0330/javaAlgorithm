import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] checker = new long[N];

        long max = 0;
        for(int i=0;i<N;i++){
            checker[i] = Long.parseLong(br.readLine());
            max = Math.max(max, checker[i]);
        }

        long l = 1;

        long r = M * max;

//        System.out.println(r);
        long t = 0;
        while(l<=r){
            long mid = (l+r)/2;

//            System.out.println(mid);
            long passCnt = 0;
            for(int i=0;i<N;i++){
                passCnt += mid/checker[i];
            }

            //System.out.println("mid : " + mid + " passCnt : " + passCnt);
            if(passCnt >= M){
                t = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        System.out.println(t);
    }
}