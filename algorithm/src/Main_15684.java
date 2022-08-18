import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684 {

    public static boolean isGameSuccess(boolean[][] lines){

        for(int i=0;i<lines[0].length;i++){
            int r = 0;
            int c = i;

            while(r<lines.length){
                if(c == 0){
                    if(lines[r][c]){
                        c++;
                    }
                }else if(c == lines[0].length){
                    if(lines[r][c-1]){
                        c--;
                    }
                }else {
                    if(lines[r][c-1]){
                        c--;
                    }else if(lines[r][c]){
                        c++;
                    }

                }
                r++;

                // 이미 불가능하면
                if(lines.length-r < Math.abs(c-i)) return false;
            }

            if(i != c) return false;
        }
        return true;
    }


    static boolean[][] baseLines;
    static int N, M, H;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 가로선 저장 배열
        baseLines = new boolean[H][N-1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt (st.nextToken());

            baseLines[r-1][c-1] = true;
        }

        answer = 4;

        dfs(0);

        System.out.println(answer==4?-1:answer);
    }


    public static void dfs(int cnt){

        if (answer <= cnt) return;
        if ((M + cnt) % 2 == 0 && isGameSuccess(baseLines)) {
            answer = answer > cnt ? cnt : answer;
        }

        if(M % 2 == 0 && cnt+1 >= 3 ) return;
        if(cnt+1 > 3) return;

        for(int i=0;i<H;i++){
            for(int j=0;j<N-1;j++){
                if(!baseLines[i][j]) {

                    // 왼쪽에 가로선이 있다면 넘어가기
                    if (j - 1 >= 0 && baseLines[i][j - 1]) continue;

                    // 오른쪽에 가로선이 있다면 넘어가기
                    if (j + 1 < N - 1 && baseLines[i][j + 1]) continue;

                    baseLines[i][j] = true;
                    dfs(cnt+1);
                    baseLines[i][j] = false;
                }
            }
        }


    }


}
