class Solution {
    public int closedIsland(int[][] grid) {
     
        int row= grid.length, col=grid[0].length, count=0;
        
        for(int i =0; i<row;i++)
        
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j] == 0 && dfs(grid,i,j))
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean dfs(int grid[][],int x, int y)
    {
        int n=grid.length,m=grid[0].length;
        if(x<0 || x>=n || y<0 || y>=m)
        {
            return false;
        }
        if(grid[x][y] == 1 )
        {
            return true;
        }
        
        grid[x][y] =1;
        boolean left=dfs(grid,x,y-1),right=dfs(grid,x,y+1);
        boolean up =dfs(grid,x-1,y),down=dfs(grid,x+1,y);
        
        return left&&right&&up&&down;
    }
}