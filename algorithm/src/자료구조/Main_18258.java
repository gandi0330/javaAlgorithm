package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18258 {
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        CustomQueue customQueue =  new CustomQueue();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command1 = st.nextToken();
            if(command1.equals("push")){
                customQueue.push(Integer.parseInt(st.nextToken()));
            }
            else if(command1.equals("front")){
                sb.append(customQueue.front()+"\n");
            }
            else if(command1.equals("back")){
                sb.append(customQueue.back()+"\n");
            }
            else if(command1.equals("pop")){
                sb.append(customQueue.pop()+"\n");
            }
            else if(command1.equals("size")){
                sb.append(customQueue.size()+"\n");
            }
            else if(command1.equals("empty")){
                sb.append(customQueue.empty()+"\n");
            }
        }

        System.out.print(sb);


    }

    public static class CustomQueue{
        static Deque<Integer> q = new LinkedList<>();

        public void push(int n){
            q.offer(n);
        }

        public int pop(){
            if(q.isEmpty()) return -1;
            return q.poll();
        }

        public int size(){
            return q.size();
        }

        public int empty(){
            if(q.isEmpty()) return 1;
            return 0;
        }

        public int front(){
            if(q.isEmpty()) return -1;
            return q.getFirst();
        }

        public int back(){
            if(q.isEmpty()) return -1;
            return q.getLast();
        }

    }
}
