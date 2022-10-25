class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int n= points.length;
        int ans =0;
        
        for(int i=0; i<n-1; i++)
        {
            int deltaX = Math.abs(points[i+1][0] - points[i][0]);
            int deltaY = Math.abs(points[i+1][1] - points[i][1]);
            
            ans += Math.min(deltaX,deltaY) + Math.abs(deltaX-deltaY);
        }
        
        return ans;
        
    }
}