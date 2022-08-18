import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        System.out.println(cal(str));

    }

    public  static int cal(String str){

        Stack<Character> stack = new Stack<>();

        int answer = 0;
        int temp = 1;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            switch (c){
                case '(':
                    temp *= 2;
                    stack.push('(');
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek() != '('){
                        return 0;
                    }else if(i>0 && str.charAt(i-1)=='('){
                        answer += temp;
                        temp /= 2;
                        stack.pop();
                    }else {
                        temp/= 2;
                        stack.pop();
                    }
                    break;
                case '[':
                    temp *= 3;
                    stack.push('[');
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '['){
                        return 0;
                    }
                    else if(i>0 && str.charAt(i-1)=='['){
                        answer += temp;
                        temp /= 3;
                        stack.pop();
                    }
                    else {
                        temp/= 3;
                        stack.pop();
                    }
                    break;
            }

        }

        return answer;
    }
}
