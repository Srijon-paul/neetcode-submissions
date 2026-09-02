class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] vis = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int row, int col, int i, char[][] board, String word, int[][] vis) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
            || board[row][col] != word.charAt(i) || vis[row][col] == 1) {
            return false;
        }
        vis[row][col] = 1;
        boolean res = dfs(row + 1, col, i + 1, board, word, vis) || 
                        dfs(row, col + 1, i + 1, board, word, vis) || 
                        dfs(row - 1, col, i + 1, board, word, vis) || 
                        dfs(row, col - 1, i + 1, board, word, vis);
        vis[row][col] = 0;
        return res;
    }
}
