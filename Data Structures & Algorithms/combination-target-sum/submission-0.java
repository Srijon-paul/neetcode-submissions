class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        fun(nums, 0, target, 0, temp, res);
        return res;
    }
    void fun(int[] nums, int index, int target, int sum, List<Integer> temp, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList(temp));
            return;
        }
        if(index >= nums.length || sum > target){
            return;
        }
        temp.add(nums[index]);
        fun(nums, index, target, sum + nums[index], temp, res);
        temp.remove(temp.size() - 1);
        fun(nums, index + 1, target, sum, temp, res);
    }
}
