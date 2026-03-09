import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && A[stack.peekLast()] < A[i]){
                ans[stack.peekLast()] = A[i];
                stack.pollLast();
            }
            stack.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(ans[i]).append(' ');

        System.out.println(sb);

    }
}
