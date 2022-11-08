class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
     
        
        int targety= coordinates[1][1] - coordinates[0][1];
        int targetx = coordinates[1][0] - coordinates[0][0];
        
        for(int i=2;i<coordinates.length;i++)
        {
            int slopex = coordinates[i][0] - coordinates[i-1][0];
          int  slopey = coordinates[i][1] - coordinates[i-1][1];
            
            if(targety*slopex != targetx*slopey)
            {
                return false;
            }
        }
        return true;
    }
}