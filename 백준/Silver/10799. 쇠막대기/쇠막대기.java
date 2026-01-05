import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int nowStick = 0;
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<input.length(); i++){
            if (input.charAt(i) == '('){
                if(i+1<input.length() && input.charAt(i+1) == ')'){
                    i++;
                    answer += nowStick;
                } else nowStick++;
            } else{
                nowStick--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}