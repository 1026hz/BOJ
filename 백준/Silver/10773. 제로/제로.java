import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int k=0; k<K; k++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && !stack.isEmpty()){
                int tmp = stack.pop();
                sum -= tmp;
            } else{
                sum += num;
                stack.push(num);
            }
        }
        System.out.println(sum);
    }
}
