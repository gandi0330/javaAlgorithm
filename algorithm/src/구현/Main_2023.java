package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2023 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 소수 판별 메서드
        // bfs로 수를 만들어 탐색(1자리, ~~~ N자리)

        Queue<String> q = new LinkedList<>();

        for(int i=2;i<=9;i++){
            q.add(i+"");
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            int num = Integer.parseInt(q.poll());

            if(isDecimal(num)){
                if((num+"").length() == N)
                    sb.append(num+"\n");
                else {
                    for (int i = 1; i <= 9; i++) {
                        q.add(num * 10 + i + "");
                    }
                }
            }

        }

        System.out.println(sb.toString());

    }


    public static boolean isDecimal(int num){
        int rootNum = (int)Math.sqrt(num);

        for(int i=2;i<=rootNum;i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}
