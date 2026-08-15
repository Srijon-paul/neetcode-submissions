class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int buy = 0, res = 0, sell = 1;
        while(sell < prices.length){
            if(prices[sell] - prices[buy] >= 0){
                res = Math.max(prices[sell] - prices[buy], res);
                sell++;
            }else{
                buy = sell;
                sell++;
            }
        }
        return res;

    }
}
