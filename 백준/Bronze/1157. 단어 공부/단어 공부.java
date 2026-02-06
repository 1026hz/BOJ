import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.toUpperCase();
        int[] alphabet = new int[30];
        int max = 0;
        for(int i=0; i<s.length(); i++){
            alphabet[s.charAt(i)-'A']++;
            if(max < alphabet[s.charAt(i)-'A']) max = alphabet[s.charAt(i)-'A'];
        }

        int count = 0;
        char ans = 'a';
        for(int i=0; i<30; i++){
            if (alphabet[i] == max) {
                ans = (char)('A' + i);
                count++;
            }
        }

        if(count == 1) System.out.println(ans);
        else System.out.println('?');

    }
}
