import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] numbers = new int[N.length()];
        for(int i=0; i<N.length(); i++){
            numbers[i] = N.charAt(i) - '0';
        }
        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for(int i=N.length()-1; i>=0; i--) sb.append(numbers[i]);
        System.out.println(sb);

    }

}
