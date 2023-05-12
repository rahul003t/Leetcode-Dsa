class Solution {
    long max;
    long[] dp;
    public long mostPoints(int[][] questions) {
        dp=new long[questions.length];
        max=0;
        for(int i=questions.length-1;i>=0;i--){
            bfs(questions,i);
        }
        return max;
    }
    public void bfs(int[][] nums,int i){
        if(i>=nums.length){return;}
        if(i==nums.length-1){
            max=nums[i][0];
            dp[i]=nums[i][0];
            return;
        }
        if(i+nums[i][1]+1<nums.length){
            dp[i]=nums[i][0]+dp[i+nums[i][1]+1];}
       else{
           dp[i]=nums[i][0];
           }
        max=Math.max(max,dp[i]);
        dp[i]=max;
    }
}