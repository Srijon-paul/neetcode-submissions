class Solution {
    // dp memoization
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount][coins.length];
        return fun(coins, 0, amount, 0, dp);
    }
    int fun(int[] coins, int sum, int amount, int i, int[][] dp){
        if(sum == amount){
            return 1;
        }
        if(i >= coins.length) return 0;
        if(sum > amount) return 0;
        if(dp[sum][i] != 0){
            return dp[sum][i];
        }
        int res = 0;
        res = fun(coins, sum, amount, i + 1, dp);
        res += fun(coins, sum + coins[i], amount, i, dp);
        dp[sum][i] = res;
        return res;
    }
}
