import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            Deque<Character> reverse = new ArrayDeque<>();

            for(char c : input.toCharArray()){
                if (c == '<'){
                    if(!stack.isEmpty()){
                        char tmp = stack.pop();
                        reverse.push(tmp);
                    }
                } else if (c == '>'){
                    if(!reverse.isEmpty()){
                        char tmp = reverse.pop();
                        stack.push(tmp);
                    }
                } else if (c == '-'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                reverse.push(stack.pop());
            }
            while(!reverse.isEmpty()){
                sb.append(reverse.pop());
            }
            System.out.println(sb);
        }

    }
}