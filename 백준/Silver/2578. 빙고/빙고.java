import java.io.*;
import java.util.*;

public class Main {

    static int[][] bingo;
    static int[][] ans;
    static boolean[][] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[5][5];
        check = new boolean[5][5];
        HashMap<Integer, int[]> map = new HashMap<>();

        StringTokenizer st;
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int num = Integer.parseInt(st.nextToken());
                bingo[i][j] = num;
                map.put(num, new int[]{i,j});
            }
        }
        int count = 0;
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                count++;
                int ans = Integer.parseInt(st.nextToken());
                int x = 0, y = 0;
                if(map.containsKey(ans)){
                    x = map.get(ans)[0];
                    y = map.get(ans)[1];
                    check[x][y] = true;
                }
                if(isBingo() >= 3){
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    static int isBingo(){
        int count = 0;

        boolean flag = false;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++) {
                if (check[i][j]) flag = true;
                else {
                    flag = false;
                    break;
                }
                if(j==4) count++;
            }
        }

        flag = false;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++) {
                if (check[j][i]) flag = true;
                else {
                    flag = false;
                    break;
                }
                if(j==4) count++;
            }
        }

        flag=false;
        for(int i=0; i<5; i++){
            if(check[i][i]) flag = true;
            else{
                flag = false;
                break;
            }
        }
        if(flag) count++;

        flag=false;
        for(int i=0; i<5; i++){
            if(check[i][4-i]) flag = true;
            else{
                flag = false;
                break;
            }
        }
        if(flag) count++;

        return count;

    }
}
