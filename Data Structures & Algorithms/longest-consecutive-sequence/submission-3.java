class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i++){
            int k =  nums[i];
            if(map.get(k - 1) == null){
                int count = 0;
                while(map.get(k) != null){
                    count++; k++;
                }
                res = Math.max(count, res);
            }
        }
        return res;
    }
}
