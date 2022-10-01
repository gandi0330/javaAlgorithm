package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20061 {
    static int[][] mat = new int[10][10];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int blueScore = 0;
        int greenScore = 0;
        for(int n=0;n<N;n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            down(t,x,y);

            greenScore += checkGreenScore();
            blueScore += checkBlueScore();



            boundRemoveGreen();
            boundRemoveBlue();

        }

        System.out.println(greenScore+blueScore);
        System.out.println(countBlock());


    }

    // 퍼즐 내리기
    public static void down(int t, int x, int y){
        if(t == 1){
            for(int r=5;r<10;r++){
                if(mat[r][y] != 0){
                    mat[r-1][y] =1;
                    break;
                }
                if(r==9) mat[r][y] = 1;
            }
            for(int c=5;c<10;c++){
                if(mat[x][c] != 0){
                    mat[x][c-1] =1;
                    break;
                }
                if(c==9) mat[x][c] = 1;
            }
        }else if(t == 2){
            for(int r=5;r<10;r++){
                if(mat[r][y] != 0 || mat[r][y+1] !=0){
                    mat[r-1][y] = 1;
                    mat[r-1][y+1] = 1;
                    break;
                }
                if(r==9) {
                    mat[r][y] = 1;
                    mat[r][y+1] = 1;
                }
            }
            for(int c=4;c<9;c++){
                if(mat[x][c] != 0 || mat[x][c+1] != 0){
                    mat[x][c-1] = 1;
                    mat[x][c+1-1] = 1;
                    break;
                }
                if(c==8) {
                    mat[x][c] = 1;
                    mat[x][c+1] = 1;
                }
            }
        }else if(t == 3){
            for(int r=4;r<9;r++){
                if(mat[r][y] != 0 || mat[r+1][y] != 0){
                    mat[r+1-1][y] = 1;
                    mat[r-1][y] = 1;
                    break;
                }
                if(r==8){
                    mat[r][y] = 1;
                    mat[r+1][y] = 1;
                }
            }
            for(int c=5;c<10;c++){
                if(mat[x][c] != 0 || mat[x+1][c] != 0){
                    mat[x+1][c-1] = 1;
                    mat[x][c-1] = 1;
                    break;
                }
                if(c==9){
                    mat[x][c] = 1;
                    mat[x+1][c] = 1;
                }
            }
        }
    }

    // 퍼즐 점수 세기
    public static int checkGreenScore(){
        int[] cleanRow = new int[10];
        int score = 0;
        for(int i=6;i<10;i++){
            int sum = 0;
            for(int j=0;j<4;j++){
                sum+=mat[i][j];
            }
            if(sum == 4){
                score++;
                for(int j=0;j<4;j++){
                    mat[i][j] =0;
                }
                for(int k=0;k<i;k++){
                    cleanRow[k]++;
                }
            }
        }
        removeEmptyRow(cleanRow);

        return score;
    }

    public static int checkBlueScore(){
        int[] cleanCol = new int[10];
        int score = 0;
        for(int j=6;j<10;j++){
            int sum = 0;
            for(int i=0;i<4;i++){
                sum += mat[i][j];
            }
            if(sum == 4){
                score++;
                for(int i=0;i<4;i++){
                    mat[i][j] = 0;
                }
                for(int k=0;k<j;k++){
                    cleanCol[k]++;
                }
            }
        }
        removeEmptyCol(cleanCol);
        return score;
    }

    // 없어진 부분 채우기
    public static void removeEmptyRow(int[] cleanRow){
        for(int i=8;i>=4;i--){
            for(int j=0;j<4;j++){
                if(cleanRow[i] != 0){
                    mat[i+cleanRow[i]][j] = mat[i][j];
                    mat[i][j] = 0;
                }
            }
        }
    }

    public static void removeEmptyCol(int[] cleanCol){
        for(int j=8;j>=4;j--){
            for(int i=0;i<4;i++){
                if(cleanCol[j] != 0){
                    mat[i][j+cleanCol[j]] = mat[i][j];
                    mat[i][j] = 0;
                }
            }
        }
    }



    // 경계 부분 없애기
    public static void boundRemoveGreen(){
        int cnt = 0;
        for(int i=4;i<6;i++){
            for(int j=0;j<4;j++){
                if(mat[i][j] == 1){
                    cnt++;
                    break;
                }
            }
        }
        if(cnt>0){
            for(int i=9;i>9-cnt;i--){
                for(int j=0;j<4;j++){
                    mat[i][j] = 0;
                }
            }
            int[] cleanRow = new int[10];
            for(int k=0;k<=9-cnt;k++){
                cleanRow[k]= cnt;
            }
            removeEmptyRow(cleanRow);
        }
    }

    public static void boundRemoveBlue(){
        int cnt = 0;
        for(int j=4;j<6;j++){
            for(int i=0;i<4;i++){
                if(mat[i][j] == 1){
                    cnt++;
                    break;
                }
            }
        }

        if(cnt>0){
            for(int j=9;j>9-cnt;j--){
                for(int i=0;i<4;i++){
                    mat[i][j] = 0;
                }
            }
            int[] cleanCol = new int[10];
            for(int k=0;k<=9-cnt;k++){
                cleanCol[k]= cnt;
            }
            removeEmptyCol(cleanCol);
        }

    }

    public static int countBlock(){
        int sum = 0;
        for(int i=6;i<10;i++){
            for(int j=0;j<4;j++){
                sum += mat[i][j] + mat[j][i];
            }
        }
        return sum;
    }
}
