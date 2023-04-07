class Solution {
    public int numEnclaves(int[][] grid) {
        
        int res=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1)
                    dfs(grid,i,j);
            }
        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1)
                    res++;
            }
        }

        return res;
    }

    private void dfs(int[][] grid,int i,int j) {
        int m=grid.length, n=grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!=1)
            return;
        
        grid[i][j]=0;
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
    }
}