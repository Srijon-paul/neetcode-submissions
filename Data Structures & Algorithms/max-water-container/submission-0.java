class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int low = 0, high = heights.length - 1;
        while(low < high){
            int width = high - low;
            int height = Math.min(heights[low], heights[high]);
            res = Math.max(res, width * height);
            
            if(heights[low] >= heights[high]){
                high--;
            }else{
                low++;
            }
        }
        return res;
    }
}
