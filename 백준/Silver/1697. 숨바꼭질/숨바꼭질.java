import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] map = new int[100001];
    static boolean[] visited = new boolean[100001];
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    public static int bfs(int x) {
        Deque<Integer> dq = new ArrayDeque<>();

        visited[x] = true;
        map[x] = 0;
        dq.addLast(x);

        while (!dq.isEmpty()) {
            int now = dq.pollFirst();
            if (now == K) return map[now];

            int next1 = now - 1;
            if (next1 >= 0 && !visited[next1]) {
                visited[next1] = true;
                map[next1] = map[now] + 1;
                dq.addLast(next1);
            }

            int next2 = now + 1;
            if (next2 <= MAX && !visited[next2]) {
                visited[next2] = true;
                map[next2] = map[now] + 1;
                dq.addLast(next2);
            }

            int next3 = now * 2;
            if (next3 <= MAX && !visited[next3]) {
                visited[next3] = true;
                map[next3] = map[now] + 1;
                dq.addLast(next3);
            }
        }

        return -1;
    }
}
