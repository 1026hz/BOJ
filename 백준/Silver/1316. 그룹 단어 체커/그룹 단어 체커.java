import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = N;
        for(int n=0; n<N; n++){
            String s = br.readLine();
            boolean[] alphabet = new boolean[30];
            for(int i=0; i<s.length(); i++){
                int nowIdx = s.charAt(i)-'a';
                if(!alphabet[nowIdx]){
                    alphabet[nowIdx] = true;
                }
                else if(alphabet[nowIdx] && s.charAt(i-1) != s.charAt(i)){
                    ans--;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
