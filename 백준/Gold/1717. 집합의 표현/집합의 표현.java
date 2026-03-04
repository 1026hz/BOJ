import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        rank = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
        Arrays.fill(rank, 1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0){
               int parentA = findParent(a);
               int parentB = findParent(b);

               if(parentA != parentB){
                   union(parentA,parentB);
               }
            } else{
                if(findParent(a) == findParent(b)) sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);


        /**StringBuilder tmp = new StringBuilder();
        for(int n : parent) tmp.append(n).append(' ');
        System.out.println(tmp);
        tmp = new StringBuilder();
        for(int n : rank) tmp.append(n).append(' ');
        System.out.println(tmp);**/

    }

    static int findParent(int child){
        while(true){
            int p = parent[child];
            if(p == child) {
                return p;
            }
            child = p;
        }
    }

    static void union(int x, int y){
        int rankX = rank[x];
        int rankY = rank[y];

        if(rankX >= rankY){
            rank[x] += rank[y];
            parent[y] = x;
        }
        else{
            rank[y] += rank[x];
            parent[x] = y;
        }

    }
}
