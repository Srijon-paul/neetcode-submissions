class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    dfs(grid, i, j, m, n, vis);
                    res++;
                }
            }
        }
        return res;
    }
    void dfs(char[][] grid, int i, int j, int m, int n, int[][] vis){
        vis[i][j] = 1;
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        for(int k = 0; k < 4; k++){
            int row = i + x[k];
            int col = j + y[k];
            if(valid(row, col, m, n) && grid[row][col] == '1' && vis[row][col] == 0){
                dfs(grid, row, col, m, n, vis);
            }
        }

    }
    boolean valid(int row, int col, int m, int n){
        if(row < 0 || col < 0 || row >= m || col >= n){
            return false;
        }
        return true;
    }
}
