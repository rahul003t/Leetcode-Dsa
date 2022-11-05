class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int result=-1,min=Integer.MAX_VALUE;
        
        for(int i=0; i<points.length; i++)
        {
            if(x ==points[i][0] || y==points[i][1])
            {
                int manH = Math.abs(x-(points[i][0]))+Math.abs(y-(points[i][1]));
                
                if(min > manH)
                {
                    min = manH;
                    result=i;
                }
            }
        }
        return result;
        
    }
}