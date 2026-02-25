import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        int k = 0;
        for(int i=1; i<M-1; i++){
            //System.out.println(i + " : " + S.substring(i-1, i+2));
            if(S.substring(i-1, i+2).equals("IOI")) k++;
            else if(S.substring(i-1,i + 2).equals("OIO")) continue;
            else k = 0;
            if(k >= N){
                count++;
            }
        }

        System.out.println(count);


    }

}
