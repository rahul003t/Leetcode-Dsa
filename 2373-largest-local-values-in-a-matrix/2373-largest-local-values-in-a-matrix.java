class Solution {
    public int[][] largestLocal(int[][] grid) {
        
        int row=grid.length;
        int col=grid[0].length;
        
        int[][] ans = new int[row-2][col-2];
        
        for(int i=1,m=0;i<row-1;i++,m++)
        {
            for(int j=1,n=0;j<col-1;j++,n++)
            {
                int  max = Integer.MIN_VALUE;
                
                for(int k=i-1;k<i-1+3;k++)
                {
                    for(int l=j-1;l<j-1+3;l++)
                    {
                        max = Math.max(max,grid[k][l]);
                    }
                }
                
                ans[m][n]=max;
                
                
            }
        }
        
        return ans;
        
    }
}