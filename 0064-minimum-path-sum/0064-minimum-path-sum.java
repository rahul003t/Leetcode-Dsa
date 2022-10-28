class Solution {
    public int minPathSum(int[][] grid) {
        
        int height = grid.length;
        int width = grid[0].length;
        
        for(int row=0;row<height;row++)
        {
            for(int col=0;col<width;col++)
            {
                if(row==0 && col==0)
                {
                    grid[row][col]=grid[row][col];
                }
                else if(row == 0 && col != 0)
                {
                    grid[row][col] = grid[row][col]+grid[row][col-1];
                }
                else if(row !=0 && col == 0)
                {
                    grid[row][col] = grid[row][col]+grid[row-1][col];
                }
                else
                {
                    grid[row][col] = grid[row][col]+Math.min(grid[row][col-1],grid[row-1][col]);
                }
            }
        }
        
        return grid[height-1][width-1];
    }
}