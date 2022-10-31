class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int m = matrix.length;
        for(int i=0; i<m-1; i++)
        {
            for(int j=0; j<matrix[i].length-1; j++)
            {
                if(matrix[i][j] != matrix[i+1][j+1] )
                {
                    return false;
                }
            }
        }
        return true;
    }
}