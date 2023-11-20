class Solution {
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int currArea = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int i, int j, int[][] grid){
        if(grid[i][j] != 1){
            return 0;
        }else{
            grid[i][j] = 2;
            int currArea = 1;
            for(int k = 0; k < dir.length; k++){
                int newRow = i + dir[k][0];
                int newCol = j + dir[k][1];
                if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length){
                    currArea += dfs(newRow, newCol, grid);
                }
            }
            return currArea;
        }
    }
}