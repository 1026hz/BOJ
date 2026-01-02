import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N+1];
        int[] ans = new int[N+1];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int curNum = Integer.parseInt(st.nextToken());
            num[i] = curNum;
            while(!stack.isEmpty() && num[stack.peekLast()] < curNum){
                ans[stack.peekLast()] = curNum;
                stack.pollLast();
            }
            stack.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }
}