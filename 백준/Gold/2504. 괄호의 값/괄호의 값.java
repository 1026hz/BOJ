import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        int mul = 1;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.addLast(c);
                mul *= 2;
            } else if (c == '[') {
                stack.addLast(c);
                mul *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peekLast() != '(') {
                    System.out.println(0);
                    return;
                }
                if (i > 0 && s.charAt(i - 1) == '(') {
                    ans += mul;
                }
                stack.pollLast();
                mul /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peekLast() != '[') {
                    System.out.println(0);
                    return;
                }
                if (i > 0 && s.charAt(i - 1) == '[') {
                    ans += mul;
                }
                stack.pollLast();
                mul /= 3;
            }
        }
        
        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(ans);
    }
}
