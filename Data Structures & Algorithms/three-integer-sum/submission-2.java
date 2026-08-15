class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = -nums[i];
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[low]);
                    lst.add(nums[high]);
                    res.add(lst);
                    low++;
                    high--;
                    while (low < nums.length && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    while (high >= 0 && nums[high] == nums[high + 1]) {
                        high--;
                    }
                } else if (nums[low] + nums[high] > sum) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return res;
    }
}
