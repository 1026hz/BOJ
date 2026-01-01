import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tower = new int[N+1];
        int[] answer = new int[N+1];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            tower[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){

            while(!stack.isEmpty() && tower[stack.peek()] < tower[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) stack.push(i);
            else{
                answer[i] = stack.peek();
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);

    }
}