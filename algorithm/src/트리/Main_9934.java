package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9934 {
    static String nodes[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCnt = (int)Math.pow(2,K) -1;
        int[] inOrder = new int[nodeCnt];
        for(int i=0;i<nodeCnt;i++){
            inOrder[i] = Integer.parseInt(st.nextToken());
        }


        nodes = new String[K];
        Arrays.fill(nodes, "");
        divide(inOrder, 0);
        for(String s : nodes){
            System.out.println(s);
        }

    }

    public static void divide(int[] arr, int depth){
        if(arr.length==0) return;

        nodes[depth]+=arr[arr.length/2]+" ";

        divide(Arrays.copyOfRange(arr, 0,arr.length/2), depth+1);
        divide(Arrays.copyOfRange(arr, arr.length/2+1,arr.length), depth+1);

    }
}
