class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        int[][] pac = new int[m][n];
        int[][] atl = new int[m][n];
        for(int i = 0; i < m; i++){
            dfs(heights, i, 0, pac, m, n);
            dfs(heights, i, n - 1, atl, m, n);
        }
        for(int i = 0; i < n; i++){
            dfs(heights, 0, i, pac, m, n);
            dfs(heights, m - 1, i, atl, m , n);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] == 1 && atl[i][j] == 1){
                    res.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return res;

    }
    void dfs(int[][] heights, int row, int col, int[][] ocean, int m, int n){
        ocean[row][col] = 1;
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        for(int k = 0; k < 4; k++){
            int r = row + x[k];
            int c = col + y[k];
            if(valid(r,c,m,n) && heights[r][c] >= heights[row][col] && ocean[r][c] == 0){
                dfs(heights, r, c, ocean, m, n);
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
