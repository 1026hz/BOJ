import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] a;
    static int[] ans = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        a = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
    }

    static void divide(int x, int y, int size) {
        if (isSame(x, y, size)) {
            ans[a[x][y] + 1]++;
            return;
        }

        int nextSize = size / 3;

        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                divide(x + dx * nextSize, y + dy * nextSize, nextSize);
            }
        }
    }

    static boolean isSame(int x, int y, int size) {
        int v = a[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (a[i][j] != v) return false;
            }
        }
        return true;
    }
}
