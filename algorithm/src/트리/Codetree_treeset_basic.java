package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Codetree_treeset_basic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<N;i++){
            String cmd = br.readLine();

            String func = cmd.split(" ")[0];

            if(func.equals("add")){
                set.add(Integer.parseInt(cmd.split(" ")[1]));
            }else if(func.equals("remove")){
                set.remove(Integer.parseInt(cmd.split(" ")[1]));
            }else if(func.equals("find")){
                System.out.println(set.contains(Integer.parseInt(cmd.split(" ")[1])));
            }else if(func.equals("lower_bound")){
                if(set.contains(Integer.parseInt(cmd.split(" ")[1]))) System.out.println(Integer.parseInt(cmd.split(" ")[1]));
                else if(set.higher(Integer.parseInt(cmd.split(" ")[1]))!=null) System.out.println(set.higher(Integer.parseInt(cmd.split(" ")[1])));
                else System.out.println("None");
            }else if(func.equals("upper_bound")){
                if(set.higher(Integer.parseInt(cmd.split(" ")[1]))!=null) System.out.println(set.higher(Integer.parseInt(cmd.split(" ")[1])));
                else System.out.println("None");
            }else if(func.equals("largest")){
                if(set.size() == 0) System.out.println("None");
                else System.out.println(set.last());
            } else if (func.equals("smallest")) {
                if(set.size() == 0) System.out.println("None");
                else System.out.println(set.first());
            }
        }

    }
}
