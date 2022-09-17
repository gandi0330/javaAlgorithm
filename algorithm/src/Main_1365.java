import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1365 {

    public static int lowerBound(List<Integer> list, int target){
        int l = 0;
        int r = list.size();

        int idx = 0;
        while(l<=r){
            int mid = (l+r)/2;

            //System.out.println("mid :"  + mid + " list.get(mid) : " + list.get(mid) + " target : " + target);
            if(list.get(mid)>= target){
                idx = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return idx;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            if(list.size() == 0)
                list.add(arr[i]);
            else if(list.get(list.size()-1) > arr[i]){
                list.set(lowerBound(list,arr[i]),arr[i]);
            }else if(list.get(list.size()-1) < arr[i]){
                list.add(arr[i]);
            }
            // System.out.println(Arrays.toString(list.toArray()));
        }

        System.out.println(N - list.size());

    }
}
