package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Student> students = new PriorityQueue<>();
        for(int i=0;i<n ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            students.add(new Student(name, a, b, c));
        }

        StringBuilder sb = new StringBuilder();

        while(!students.isEmpty()) sb.append(students.poll().name+"\n");

        System.out.print(sb);
    }

    public static class Student implements Comparable<Student> {
        String name;
        int a;
        int b;
        int c;

        Student(String name, int a, int b, int c){
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Student o2) {
            if(this.a != o2.a){
                return o2.a - this.a;
            }
            else if(this.b != o2.b){
                return this.b - o2.b;
            }
            else if(this.c != o2.c){
                return o2.c - this.c;
            }
            return this.name.compareTo(o2.name);
        }

    }

}
