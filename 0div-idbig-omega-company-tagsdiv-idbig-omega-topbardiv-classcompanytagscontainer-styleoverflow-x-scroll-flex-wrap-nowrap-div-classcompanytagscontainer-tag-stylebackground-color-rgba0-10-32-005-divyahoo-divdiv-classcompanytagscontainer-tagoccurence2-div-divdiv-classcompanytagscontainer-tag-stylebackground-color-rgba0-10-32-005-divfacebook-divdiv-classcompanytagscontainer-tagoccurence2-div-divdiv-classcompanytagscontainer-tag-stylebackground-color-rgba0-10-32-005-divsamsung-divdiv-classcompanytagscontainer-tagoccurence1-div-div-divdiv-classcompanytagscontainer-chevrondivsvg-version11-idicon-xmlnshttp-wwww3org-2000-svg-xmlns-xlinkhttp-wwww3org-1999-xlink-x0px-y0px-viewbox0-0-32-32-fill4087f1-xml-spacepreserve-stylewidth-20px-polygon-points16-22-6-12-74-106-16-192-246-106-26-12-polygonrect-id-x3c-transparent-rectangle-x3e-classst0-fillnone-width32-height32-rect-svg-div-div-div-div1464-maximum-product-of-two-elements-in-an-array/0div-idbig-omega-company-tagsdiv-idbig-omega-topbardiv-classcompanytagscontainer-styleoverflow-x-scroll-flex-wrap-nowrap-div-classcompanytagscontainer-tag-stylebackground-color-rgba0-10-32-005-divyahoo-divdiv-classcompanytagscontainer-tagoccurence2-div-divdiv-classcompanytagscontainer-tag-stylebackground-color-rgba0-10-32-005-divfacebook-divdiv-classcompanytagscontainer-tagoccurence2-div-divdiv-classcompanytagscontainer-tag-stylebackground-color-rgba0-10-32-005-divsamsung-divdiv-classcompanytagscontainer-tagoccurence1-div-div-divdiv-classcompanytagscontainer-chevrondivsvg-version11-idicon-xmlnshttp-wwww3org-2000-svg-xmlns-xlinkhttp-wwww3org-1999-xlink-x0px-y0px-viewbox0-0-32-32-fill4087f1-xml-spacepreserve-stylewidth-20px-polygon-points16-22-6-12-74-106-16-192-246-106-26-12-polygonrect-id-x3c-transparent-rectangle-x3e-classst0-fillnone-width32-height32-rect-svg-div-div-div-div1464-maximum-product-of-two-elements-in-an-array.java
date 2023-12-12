class Solution {
    public int maxProduct(int[] nums) {
        int res = 0;
        int curMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, (curMax - 1) * (nums[i] - 1));
            curMax = Math.max(curMax, nums[i]);
        }

        return res;        
    }
}