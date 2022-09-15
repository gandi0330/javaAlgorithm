package 삼성B형.메모장프로그램;

import java.util.Arrays;

class UserSolution
{
    static int[][] alphaNumToRow;
    static Node cursor;
    static Node endNode;
    static char[][] figure;
    static class Node{
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    void init(int H, int W, char mStr[])
    {
        alphaNumToRow = new int[H][26];
        cursor = new Node(0,0);
        endNode = new Node(0,0);
        figure = new char[H][W];
        int idx = 0;
        loop : for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(mStr[idx] != '\0'){
                    figure[i][j] = mStr[idx];
                    alphaNumToRow[i][mStr[idx]-'a']++;
                }else{
                    endNode.r = i;
                    endNode.c = j;
                    break loop;
                }
                idx++;
            }
        }


    }


    void insert(char mChar)
    {
        int i=endNode.r;
        int j=endNode.c;

        while(true){
            if(i == cursor.r && j == cursor.c){
                figure[i][j] = mChar;
                alphaNumToRow[i][mChar-'a']++;
                break;
            }

            if(j<0){
                i--;
                j=figure[0].length-1;
                continue;
            }

            if(i<0){
                break;
            }

            if(j-1 >=0){
                figure[i][j] = figure[i][j-1];
            }else{
                figure[i][j] = figure[i-1][figure[0].length-1];
                alphaNumToRow[i][figure[i-1][figure[0].length-1]-'a']++;
                alphaNumToRow[i-1][figure[i-1][figure[0].length-1]-'a']--;
            }
            j--;

        }

        if(cursor.c +1 < figure[0].length){
            cursor.c += 1;
        }else{
            cursor.r+=1;
            cursor.c = 0;
        }

        if(endNode.c + 1 < figure[0].length){
            endNode.c += 1;
        }else{
            endNode.r+=1;
            endNode.c = 0;
        }
    }

    char moveCursor(int mRow, int mCol)
    {
        mRow-=1;
        mCol-=1;
        if(figure[mRow][mCol] != '\0'){
            cursor.r = mRow;
            cursor.c = mCol;
            return figure[mRow][mCol];
        }
        else {
            cursor.r = endNode.r;
            cursor.c = endNode.c;
            return '$';
        }
    }

    int countCharacter(char mChar)
    {

        int cnt =0;

        for(int c=cursor.c;c<figure[0].length;c++){
            if(figure[cursor.r][c] == mChar) cnt++;
        }

        for(int r=cursor.r+1;r<figure.length;r++){
            cnt += alphaNumToRow[r][mChar-'a'];
        }

        return cnt;
    }
}