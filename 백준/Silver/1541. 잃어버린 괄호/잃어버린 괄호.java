import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] minusParts = s.split("-");

        int ans = 0;
        boolean flag = false;
        for(String minusPart : minusParts){
            String[] plusParts = minusPart.split("\\+");
            int nowPlus = 0;
            for(String num : plusParts){
                nowPlus += Integer.parseInt(num);
            }
            if(!flag) {
                ans += nowPlus;
                flag = true;
            }
            else ans -= nowPlus;
        }

        System.out.println(ans);
    }
}
