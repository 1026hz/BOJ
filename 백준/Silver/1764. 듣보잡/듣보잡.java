import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> people = new HashSet<>();

        for(int i=0; i<N; i++){
            String name = br.readLine();
            people.add(name);
        }

        int count = 0;
        List<String> ans = new ArrayList<>();
        for(int i=0; i<M; i++){
            String name = br.readLine();
            if(people.contains(name)) {
                count++;
                ans.add(name);
            }
        }

        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for(String s : ans) sb.append(s).append('\n');
        System.out.println(sb);




    }
}
