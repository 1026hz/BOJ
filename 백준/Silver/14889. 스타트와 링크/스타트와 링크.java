import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 0);

        System.out.println(ans);

    }

    public static void dfs(int start, int count){
        if(count == N/2){
            ans = Math.min(ans, cal());
        }

        for(int i=start; i<=N; i++){
            visited[i] = true;
            dfs(i+1, count+1);
            visited[i] = false;
        }

    }

    public static int cal(){
        int team1 = 0;
        int team2 = 0;

        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                if(visited[i] && visited[j]) {
                    team1 += graph[i][j];
                    team1 += graph[j][i];
                } else if(!visited[i] && !visited[j]){
                    team2 += graph[i][j];
                    team2 += graph[j][i];
                }
            }
        }

        return Math.abs(team1 - team2);
    }
}
