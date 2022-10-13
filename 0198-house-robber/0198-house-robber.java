class Solution {
    public int rob(int[] nums) {
        
        int[][] arr = new int[nums.length+1][2];
        for(int i=1;i<=nums.length;i++)
        {
            arr[i][0] = Math.max(arr[i-1][0], arr[i-1][1]);
            arr[i][1] = nums[i-1] + arr[i-1][0];
           
        }
        
        return Math.max(arr[nums.length][0], arr[nums.length][1]);
    }
}
    
    