package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 1;
        int num = 1;
        int[] nums = new int[1001];
        boolean end = false;
        while(!end){
            for(int i=0;i<num;i++){
                nums[idx] = nums[idx-1]+num;
                idx++;
                if(idx>1000) {
                    end=true;
                    break;
                }
            }

            num++;
        }

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(nums[B]-nums[A-1]);




    }
}
