import java.io.*;
import java.util.*;

public class Main {
    static long N, R, C, count, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        count = 0;
        ans = 0;
        long size = (long)Math.pow(2, N);
        solve(0, 0, size);
        System.out.println(ans);
    }

    static void solve(long x, long y, long size){
        if(size == 1){
            return;
        }

        long nextSize = size / 2;
        long quadSize = (long)nextSize * nextSize;

        if (R < x + nextSize && C < y + nextSize) {
            solve(x, y, nextSize);
        } else if (R < x + nextSize && C >= y + nextSize) {
            ans += quadSize;
            solve(x, y + nextSize, nextSize);
        } else if (R >= x + nextSize && C < y + nextSize) {
            ans += 2 * quadSize;
            solve(x + nextSize, y, nextSize);
        } else {
            ans += 3 * quadSize;
            solve(x + nextSize, y + nextSize, nextSize);
        }

        return;
    }
}
