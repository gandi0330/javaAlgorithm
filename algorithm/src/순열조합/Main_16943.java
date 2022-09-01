package 순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16943 {
    static int[] nums;
    static int[] permuNums;
    static boolean[] isSelected;
    static int B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        B = Integer.parseInt(st.nextToken());

        nums = new int[A.length()];
        for(int i=0;i<A.length();i++){
            nums[i] = A.charAt(i) -'0';
        }

        Arrays.sort(nums);

        permuNums = new int[nums.length];
        isSelected = new boolean[nums.length];
        C = -1;
        permu(0,nums.length);
        System.out.println(C);
    }

    public static void permu(int cnt, int target){
        if(cnt == target){
            String str = "";
            if(permuNums[0] == 0) return;
            for(int i : permuNums){
                str+=i;
            }

            int answer = Integer.parseInt(str);

            if(answer < B) {
                C = answer;
            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(isSelected[i])continue;
            permuNums[cnt] = nums[i];
            isSelected[i] = true;
            permu(cnt+1, target);
            isSelected[i] = false;
        }
    }
}
