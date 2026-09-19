class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int low = 0, high = heights.length - 1;
        while(low < high){
            int width = high - low;
            int len = Math.min(heights[high], heights[low]);
            res = Math.max(res, width * len);
            if(heights[high] > heights[low]){
                low++;
            }else{
                high--;
            }
        }
        return res;
    }
}
