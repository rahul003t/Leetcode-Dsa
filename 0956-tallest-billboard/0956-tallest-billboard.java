class Solution {
    int ans=-1;
   Integer[][] dp;
    int solve(int[] rods,int idx,int diff){
        if(idx==rods.length){

            // diff 0 means both side have equal length x-x=0
            if(diff==0)
            return 0;

            return Integer.MIN_VALUE;
        }

        if(dp[idx][diff+5000]!=null)
        return dp[idx][diff+5000];

        // Exclude current element
       int a= solve(rods,idx+1,diff);

       //add to left support
       // l1- l2 = diff   ------------1
       //  l1+x - l2 = diff
       // (l1-l2) + x
       // diff + x   beacause l1-l2 = diff
       int b= rods[idx]+solve(rods,idx+1,diff+rods[idx]);

       //add to right support
       // l1- l2 = diff   ------------1
       //  l1 - l2+x = diff
       // (l1-l2) - x
       // diff - x   beacause l1-l2 = diff
        int c= rods[idx]+solve(rods,idx+1,diff-rods[idx]);

       return dp[idx][diff+5000]=Math.max(a,Math.max(b,c));
    }
    public int tallestBillboard(int[] rods) {
        dp = new Integer[21][2*5000];

        //  divide it by 2 because it will return sum of rod of both side so dividing it by 2 will provide one side length. see trea diagram.
       return  solve(rods,0,0)/2;
        
    }
}