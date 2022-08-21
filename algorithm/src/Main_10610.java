import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();

        List<Integer> numList = new ArrayList<>();
        int sum = 0;
        int zeroCnt = 0;

        for(int i=0;i<nums.length();i++){
            int num = (int)(nums.charAt(i) - '0');
            numList.add(num);
            if(num == 0) zeroCnt++;
            sum+= num;
        }

        if(sum % 3 ==0 && zeroCnt > 0){
            Collections.sort(numList, ((o1, o2) -> o2.compareTo(o1)) );
            StringBuilder sb = new StringBuilder();
            numList.forEach((i)->sb.append(i));
            System.out.println(sb);
        }
        else System.out.println(-1);


    }
}
