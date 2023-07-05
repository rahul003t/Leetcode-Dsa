class Solution {
    public int longestSubarray(int[] nums) {
        int flag=0;int after=0;int max=0,countOne=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=1){
                if(flag!=1){
                    flag=1;
                }
                else{
                    max=Math.max(max,after+countOne);
                    countOne=after;
                    after=0;
                }
            }
            else{
                if(flag==1){
                    after++;
                    max=Math.max(max,after+countOne);
                }
                else{
                    countOne++;
                }
            }
        }
        if(countOne==nums.length) return nums.length-1;
        return max;
    }
}