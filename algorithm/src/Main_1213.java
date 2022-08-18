import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1213{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        int[] charArr = new int['Z'-'A'+1];

        for(int c : name.toCharArray())
            charArr[c-'A']++;

        StringBuilder tempSb = new StringBuilder();
        StringBuilder answerSb = new StringBuilder();
        boolean isDo = true;
        // 길이가 짝수일 때
        if(name.length() % 2 == 0){
            for(int i=0;i<'Z'-'A'+1;i++){
                if(charArr[i] % 2 == 1){
                    isDo = false;
                    break;
                }else{
                    for(int j=0;j<charArr[i]/2;j++){
                        tempSb.append((char)('A'+i));
                    }
                }
            }
            answerSb.append(tempSb);
            answerSb.append(tempSb.reverse());

        }else { // 홀수일 때
            char odd = 0;
            for(int i=0;i<'Z'-'A'+1;i++){
                if(charArr[i] % 2 == 1){
                    if(odd != 0){
                        isDo = false;
                        break;
                    }
                    odd = (char)('A'+i);
                }

                for(int j=0;j<charArr[i]/2;j++){
                    tempSb.append((char)('A'+i));
                }

            }
            answerSb.append(tempSb);
            answerSb.append(odd+tempSb.reverse().toString());
        }

        if(!isDo) System.out.println("I'm Sorry Hansoo");
        else System.out.println(answerSb);
    }










}
