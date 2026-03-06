import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[N+1];
        Arrays.fill(ans, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            while(!stack.isEmpty() && numbers[stack.peekLast()] < numbers[i]){
                ans[stack.pollLast()] = numbers[i];
            }
            stack.offerLast(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) sb.append(ans[i]).append(' ');
        System.out.println(sb);
    }
}
