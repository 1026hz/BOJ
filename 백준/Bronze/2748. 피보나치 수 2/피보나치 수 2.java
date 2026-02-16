import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long pre1 = 1;
        long pre2 = 1;

        for(int i=2; i<N; i++){
            long tmp = pre1 + pre2;
            pre1 = pre2;
            pre2 = tmp;
        }

        System.out.println(pre2);
    }
}
