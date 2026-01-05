import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int goodWord = 0;

        for(int i=0; i<N; i++){
            Deque<Character> stack = new ArrayDeque<>();
            String word = br.readLine();

            for(char c : word.toCharArray()){
                if(stack.isEmpty()) {
                    stack.addLast(c);
                }
                else{
                    char top = stack.peekLast();
                    if(c == top){
                        stack.pollLast();
                    } else {
                        stack.addLast(c);
                    }
                }
            }
            if(stack.isEmpty()) goodWord++;
        }

        System.out.println(goodWord);
    }
}