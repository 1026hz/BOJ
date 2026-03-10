import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String S = br.readLine();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            while(K > 0 && !stack.isEmpty() && stack.peekLast() < (int)S.charAt(i)-'0'){
                K--;
                stack.pollLast();
            }
            stack.offerLast((int)S.charAt(i) - '0');
        }

        while(K > 0){
            stack.pollLast();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        for(int n : stack) sb.append(n);
        System.out.println(sb);


    }
}
