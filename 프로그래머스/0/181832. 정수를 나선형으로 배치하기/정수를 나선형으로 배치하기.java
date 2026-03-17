class Solution {
    public int[][] solution(int n) {
        
        int[][] answer=  new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int x = 0;
        int y = 0;
        int number = 1;
        int direction = 0;
        int cnt = 0;
        
        while(number <= n*n){
            
            while(x>=0 && y>=0 && x<n && y<n && answer[x][y] == 0){
                answer[x][y] = number;
                x += dx[direction];
                y += dy[direction];
                number++;
            }
            
            x -= dx[direction];
            y -= dy[direction];
            
            if(direction == 3) direction = 0;
            else direction++;
            
            x += dx[direction];
            y += dy[direction];
        }
        
        
        return answer;
    }
}