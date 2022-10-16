class Solution {
    public int jump(int[] nums) {
        
        int jumps=0,currJump=0,farJump=0;
        for(int i=0; i<nums.length-1;i++)
        {
            farJump = Math.max(farJump,i+nums[i]);
            
            if(i == currJump)
            {
                jumps++;
                currJump = farJump;
            }
        }
        
        return jumps;
    }
}