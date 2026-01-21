import java.io.*;
import java.util.*;

public class Main {
    static int[][] quadTree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        quadTree = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            String line = br.readLine();
            for(int j=1; j<=n; j++){
                quadTree[i][j] = line.charAt(j-1) - '0';
            }
        }
        solve(1,1, n);
        System.out.println(sb);
    }

    static void solve(int x, int y, int size){
        if(checkNumber(x, y, size)){
            sb.append(quadTree[x][y]);
            return;
        }

        sb.append('(');
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                solve(x + size/2 * i, y + size/2 * j,size/2);
            }
        }
        sb.append(')');

    }

    static boolean checkNumber(int x, int y, int size){
        int firstNumber = quadTree[x][y];
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if (firstNumber != quadTree[i][j]) return false;
            }
        }
        return true;
    }

}
