class Solution {
    public int maxProfit(int[] prices) {
      
        int minSofar = prices[0];
        int maxprofit = 0;
        for(int i=0;i<prices.length;i++){
            
            minSofar = Math.min(minSofar,prices[i]);
            int profit =  prices[i] - minSofar;
            maxprofit = Math.max(maxprofit,profit);
        }
        
        return maxprofit;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         int minsoFar = prices[0];
//         int maxProfit =0;
//         for(int i=0;i<prices.length;i++){
//             minsoFar = Math.min(minsoFar, prices[i]);
//             int profit = prices[i] - minsoFar;
//             maxProfit = Math.max(maxProfit,profit);
//         }
//         return maxProfit;
    }
}