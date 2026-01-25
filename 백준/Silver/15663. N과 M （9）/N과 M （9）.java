import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] numbers;
    static boolean[] isUsed;
    static int[] ansArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N+1];
        isUsed = new boolean[N+1];
        ansArr = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers, 1, N+1); // 0번 원소 영향 제거(권장)

        solve(1);
        System.out.print(sb);
    }

    public static void solve(int nowIdx) {
        if (nowIdx == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(ansArr[i]).append(' ');
            sb.append('\n');
            return;
        }

        int prev = 0;
        for (int i = 1; i <= N; i++) {
            if (isUsed[i]) continue;
            if (numbers[i] == prev) continue;

            isUsed[i] = true;
            ansArr[nowIdx] = numbers[i];
            prev = numbers[i];
            solve(nowIdx + 1);
            isUsed[i] = false;
        }
    }
}