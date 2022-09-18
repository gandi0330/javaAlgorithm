package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2352 {

    public static int lowerBound(int[] arr, int n, int idx){
        int start = 0;
        int end = idx;

        int ans = 0;
        while(start <= end){
            int mid = (start+end)/2;

            if(arr[mid] > n){
                ans = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[n];
        int idx = -1;
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());

            if(idx==-1 || arr[idx] < num){
                arr[++idx] = num;
            }else if(arr[idx] >= num){
                arr[lowerBound(arr, num, idx)] =  num;
            }
//            System.out.println(Arrays.toString(arr));
        }

        System.out.println(idx+1);

    }
}
