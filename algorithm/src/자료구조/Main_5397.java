package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while(T-->0){
            String str = br.readLine();

            Deque<Character> left = new LinkedList<>();
            Deque<Character> right = new LinkedList<>();

            for(Character c : str.toCharArray()){
                switch(c){
                    case '<':
                        if(!left.isEmpty()) right.addFirst(left.pollLast());
                        break;
                    case '>':
                        if(!right.isEmpty()) left.addLast(right.pollFirst());
                        break;
                    case '-':
                        if(!left.isEmpty()) left.pollLast();
                        break;
                    default:
                        left.addLast(c);
                }
            }

            left.forEach((c)->answer.append(c));
            right.forEach((c)->answer.append(c));
            answer.append("\n");
        }
        System.out.print(answer);
    }
}
