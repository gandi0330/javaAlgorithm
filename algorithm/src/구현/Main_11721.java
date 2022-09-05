package 구현;

import java.io.*;

public class Main_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length()/10;i++){
            sb.append(str.substring(i*10, i*10+10)+"\n");
        }
        if(str.length()%10 != 0){
            sb.append(str.substring(sb.length()/10*10)+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
