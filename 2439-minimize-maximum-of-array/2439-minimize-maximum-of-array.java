class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long temp = 0; int ans = 0;
        for(int i = 0; i < n; ++i){
            temp += nums[i];
            ans = (int)Math.max(ans, Math.ceil(temp/(double)(i+1)));
        }
        return ans;
    }
}