import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17401 {

    public static class Matrix{
        long[][] mat = new long[N][N];

        Matrix(long[][] mat){
            this.mat = mat;
        }

    }
    public static Matrix mul(Matrix a, Matrix b){
        long [][] temp = new long[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    temp[i][j] += (a.mat[i][k]*b.mat[k][j]) % 1000000007;
                }
            }
        }

        return new Matrix(temp);
    }
    static int N, D;
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        List<Matrix> matList = new ArrayList<>();

        for(int t=0;t<T;t++){
            long[][] temp = new long[N][N];
            int M = Integer.parseInt(br.readLine());

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                temp[a][b] = c;
            }

            matList.add(new Matrix(temp));
        }

        int t = D / T;
        int r = D % T;

        Matrix ansMat = matList.get(0);
            // 한바퀴 안돌 때
        if(t == 0){
            for(int i=1;i<D;i++){

                ansMat = mul(ansMat,matList.get(i));
            }
        }else{

            for(int i=1;i<T;i++){
                ansMat = mul(ansMat,matList.get(i));
            }


            ansMat = powMat(ansMat, t);

            for(int i=0;i<r;i++){
                ansMat = mul(ansMat,matList.get(i));
            }
        }


        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(ansMat.mat[i][j]+" ");
            }
            sb.append("\n");
        }

            System.out.print(sb);

    }

    public static Matrix powMat(Matrix a, int n){

            if(n == 2){
                return mul(a,a);
            }else if( n==1){
                return a;
            }

            Matrix b = mul(powMat(a,n/2), powMat(a, n/2));

            return b;
    }
}
