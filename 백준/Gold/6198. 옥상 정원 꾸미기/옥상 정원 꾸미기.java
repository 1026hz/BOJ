import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        Long answer = 0L;

        for(int i=0; i<N; i++){
            int nowHeight = Integer.parseInt(br.readLine());
            while( !stack.isEmpty() && stack.peekLast() <= nowHeight ){
                stack.pollLast();
            }
            answer += stack.size();
            stack.addLast(nowHeight);
        }

        System.out.println(answer);
    }
}