class Solution {
    public int solution(int[][] sizes) {
        int maxRow = 0;
        int maxColumn = 0;
        
        for(int i=0; i<sizes.length; i++){
            int tmpMaxRow = 0;
            int tmpMaxColumn = 0;
            if(sizes[i][0] >= sizes[i][1]) {
                tmpMaxRow = sizes[i][0];
                tmpMaxColumn = sizes[i][1];
            } else {
                tmpMaxRow = sizes[i][1];
                tmpMaxColumn = sizes[i][0];
            }
            
            if(maxRow < tmpMaxRow) maxRow = tmpMaxRow;
            if(maxColumn < tmpMaxColumn) maxColumn = tmpMaxColumn;
        }
        
        int answer = maxRow * maxColumn;
        return answer;
    }
}