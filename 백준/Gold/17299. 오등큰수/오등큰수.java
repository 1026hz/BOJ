import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        HashMap<Integer, Integer> F = new HashMap<>();
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            A[i] = num;
            if(F.containsKey(A[i])) F.replace(A[i], F.get(A[i]) + 1);
            else F.put(A[i], 0);
        }

        for(int i=0; i<N; i++){

            while(!stack.isEmpty() && F.get(A[stack.peekLast()]) < F.get(A[i])){
                ans[stack.peekLast()] = A[i];
                stack.pollLast();
            }
            stack.add(i);

        }

        StringBuilder sb = new StringBuilder();
        for(int n : ans) sb.append(n).append(' ');
        System.out.println(sb);


    }
}
