class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return fun(0, 0, s, p, dp);
    }
    boolean fun(int i, int j, String s, String p, Boolean[][] dp) {
        if (i >= s.length()) {
            if (j >= p.length())
                return true;
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                if(dp[i][j] != null){
                    return dp[i][j];
                }
                dp[i][j] = fun(i, j + 2, s, p, dp);
                return dp[i][j];
            }
            return false;
        }
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if(dp[i][j] != null){
                return dp[i][j];
            }
            boolean skip = fun(i, j + 2, s, p, dp);
            dp[i][j] = skip;
            if(j < p.length() && i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')){
                dp[i][j] = skip || fun(i + 1, j, s, p, dp);
            }
            return dp[i][j];
        }
        if (j < p.length() && i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
            if(dp[i][j] != null){
                return dp[i][j];
            }
            dp[i][j] = fun(i + 1, j + 1, s, p, dp);
            return dp[i][j];
        }
        return false;
    }
}
