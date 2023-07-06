class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        
        
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(right<nums.length){
            if(sum < target){
                sum += nums[right];
                ++right;
            }else if(sum >= target){
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                ++left;
            }
        }
        while(left < nums.length){
                if(sum < target) break;
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                ++left;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}