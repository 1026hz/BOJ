import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(1, 3, n);
        System.out.println(count);
        System.out.println(sb);
    }
    static void hanoi(int from, int to, int n){
        count++;
        if(n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }
        hanoi(from, 6-from-to, n-1);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(6-from-to, to, n-1);
    }
}
