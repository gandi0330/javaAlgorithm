package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] numArr = new long[N+1];

        for(int i=0;i<N;i++){
            numArr[i] = Long.parseLong(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        SegmentTree stree = new SegmentTree(N);
        stree.init(numArr, 1, 1, N);
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                long diff = c - numArr[b];
                numArr[b] = c;
                stree.update(1,1, N, b, diff);
            }else{
                long result = stree.sum(1,1, N, b, (int)c);
                sb.append(result+"\n");
            }
        }
        System.out.print(sb);

    }

    public static class SegmentTree{
        long tree[];

        SegmentTree(int N){
//            System.out.println(Math.ceil(Math.log(N)/Math.log(2)));
            tree = new long[(int)Math.pow(Math.ceil(Math.log(N)/Math.log(2)),2)+1];
//            System.out.println(tree.length);
        }

        long init(long[] arr, int node, int start, int end){
            // 리프노드인 경우
            if(start == end){
//                System.out.println(node+ " " + start);
                return tree[node] = arr[start];
            }else{
                return tree[node] = init(arr, node*2, start, (start+end)/2) + init(arr, node*2+1, (start+end)/2+1, end);
            }
        }

        long sum(int node, int start, int end, int left, int right){
            if(end < left || right < 0){
                return 0;
            }else if(left <= start && end <= right){
                return tree[node];
            }else{
                return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right);
            }
        }

        void update(int node, int start, int end, int index, long diff){
            if(index < start || end < index){
                return;
            }else{
                tree[node] = tree[node] + diff;

                if(start != end){
                    update(node*2, start, (start+end)/2, index, diff);
                    update(node*2+1, (start+end)/2+1, end, index, diff);
                }
            }
        }
    }
}
