class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int maxSoFar = values[0];
        int result =0;
        
        for(int i=1;i<values.length;i++)
        {
            result = Math.max(result, maxSoFar+values[i]-i);
            maxSoFar = Math.max(maxSoFar, values[i]+i);
        }
        
        return result;
    }
}