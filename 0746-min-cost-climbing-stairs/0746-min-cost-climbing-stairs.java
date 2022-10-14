class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] arr = new int[cost.length+1];
        arr[0]=cost[0];
        arr[1]=cost[1];
        for(int i=2;i<=cost.length;i++){
            
             arr[i] = (i == cost.length ? 0 : cost[i]) + Math.min(arr[i-1],arr[i-2]); 
            
            
        }
        
        return arr[cost.length];
        
    }
}