import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        int m3 = lcm(m1, m2);
        int n3 = n1*(m3/m1) + n2*(m3/m2);
        int newGcd = gcd(n3, m3);
        System.out.println(n3/newGcd + " " + m3/newGcd);

    }

    public static int gcd(int a, int b){
        int tmp = 0;
        while(b != 0){
            tmp =  a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static int lcm(int a, int b){
        return a*b/gcd(a, b);
    }
}
