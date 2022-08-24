import java.io.*;
import java.util.StringTokenizer;

public class Main_1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dayOfWeek = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int dayDiff = 0;

        for(int m=1;m<x;m++){
            dayDiff += days[m];
        }

        dayDiff += y;

        bw.write(dayOfWeek[dayDiff%7]);
        bw.flush();
        bw.close();

    }
}
