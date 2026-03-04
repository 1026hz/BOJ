import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] graph;
    static List<int[]> house;
    static List<int[]> chicken;
    static int[][] dist;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                if(num == 1) house.add(new int[]{i,j});
                else if(num == 2) chicken.add(new int[]{i,j});
            }
        }

        dist = new int[house.size()][chicken.size()];
        for(int i=0; i<house.size(); i++){
            for(int j=0; j<chicken.size(); j++){
                dist[i][j] = Math.abs(house.get(i)[0] - chicken.get(j)[0]) + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
            }
        }

        visited = new boolean[chicken.size()];

        dfs(0,0);

        System.out.println(ans);

    }

    static void dfs(int start, int depth){
        if(depth == M){
            cal();
            return;
        }
        for(int i=start; i<chicken.size(); i++){
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }

    static void cal(){
        int sum = 0;

        for(int i=0; i<house.size(); i++){
            int minDist = Integer.MAX_VALUE;
            for(int j=0; j<chicken.size(); j++){
                if(visited[j]) minDist = Math.min(minDist, dist[i][j]);
            }
            sum += minDist;
        }
        ans = Math.min(ans, sum);
    }

}
