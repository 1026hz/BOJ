import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] alphabet = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
        for(String alpha : alphabet){
            s = s.replace(alpha, "1");
        }

        System.out.println(s.length());
    }
}
