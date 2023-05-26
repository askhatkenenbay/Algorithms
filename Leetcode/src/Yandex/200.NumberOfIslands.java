class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res+=1;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public void dfs(char[][] grid, int i, int j){
        if(grid[i][j] == '1'){
            grid[i][j] = '2';
            for(int[] arr : dir){
                int x = i + arr[0];
                int y = j + arr[1];
                if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length){
                    dfs(grid, x, y);
                }
            }
        }
    }
}