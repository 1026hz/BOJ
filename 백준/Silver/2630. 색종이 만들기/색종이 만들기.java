import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(1, 1, N);
        System.out.println(white);
        System.out.println(blue);

    }

    static void divide(int x, int y, int size){

        if(numberCheck(x, y, size)){
            if(arr[x][y] == 0) white++;
            else blue++;
            return;
        }

        int nextSize = size / 2;

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                divide(x + nextSize * i, y + nextSize * j, nextSize);
            }
        }

    }

    static boolean numberCheck(int x, int y, int size){
        int firstNum = arr[x][y];
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(firstNum != arr[i][j]) return false;
            }
        }
        return true;
    }
}
