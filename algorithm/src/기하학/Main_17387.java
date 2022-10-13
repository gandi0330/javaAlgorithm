package 기하학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17387 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x1 = Integer.parseInt(st.nextToken());
        long y1 = Integer.parseInt(st.nextToken());
        long x2 = Integer.parseInt(st.nextToken());
        long y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long x3 = Integer.parseInt(st.nextToken());
        long y3 = Integer.parseInt(st.nextToken());
        long x4 = Integer.parseInt(st.nextToken());
        long y4 = Integer.parseInt(st.nextToken());

        long a = ccw(x1,y1,x2,y2,x3,y3);
        long b = ccw(x1,y1,x2,y2,x4,y4);
        long c = ccw(x3,y3,x4,y4,x1,y1);
        long d = ccw(x3,y3,x4,y4,x2,y2);

        if(a==0&&b==0&&c==0&&d==0) {
            long minX = 1000001;
            long minY = 1000001;
            long maxX = -1000001;
            long maxY = -1000001;
            minX = Math.min(minX, x1);
            minX = Math.min(minX, x2);
            minX = Math.min(minX, x3);
            minX = Math.min(minX, x4);
            minY = Math.min(minY, y1);
            minY = Math.min(minY, y2);
            minY = Math.min(minY, y3);
            minY = Math.min(minY, y4);
            maxX = Math.max(maxX, x1);
            maxX = Math.max(maxX, x2);
            maxX = Math.max(maxX, x3);
            maxX = Math.max(maxX, x4);
            maxY = Math.max(maxY, y1);
            maxY = Math.max(maxY, y2);
            maxY = Math.max(maxY, y3);
            maxY = Math.max(maxY, y4);
            if (getDist(minX, maxX, minY, maxY) <= getDist(x1, x2, y1, y2) + getDist(x3, x4, y3, y4)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }else if(((a>=0 && b<=0) || (a<=0 && b>=0))&&((c>=0 && d<=0) || (c<=0 && d>=0))){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

    public static long ccw(long x1, long y1, long x2, long y2, long x3, long y3){
        return x1*y2+x2*y3+x3*y1 - (y1*x2+y2*x3+y3*x1);
    }

    public static double getDist(long x1, long x2, long y1, long y2){
        return Math.sqrt(Math.pow(Math.abs(x1-x2),2)+ Math.pow(Math.abs(y1-y2),2));
    }
}
