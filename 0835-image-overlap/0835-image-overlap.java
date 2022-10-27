class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int largestOverLap=0;
        for(int row = -img1.length+1; row < img1.length; row++)
        {
            for(int col=-img1.length+1; col< img1.length;col++)
            {
                largestOverLap = Math.max(largestOverLap,  overLapOnes(img1,img2,row,col));
                
            }
        }
        
        return largestOverLap;
        
    }
    
    
   private  int overLapOnes(int[][] A, int [][] B, int rowOff, int colOff)
    {        
        int count=0;
    
        
        for(int row=0; row <A.length; row++)
        {
            for(int col=0; col<A[0].length; col++)
            {
                if((row+rowOff < 0 || row+rowOff >= A.length ) || (col+colOff <0 || col + colOff >= A[0].length))
                {
                    continue;
                }
                
                if(A[row][col] + B[row+rowOff][col+colOff] ==2)
                {
                    count++;
                }
            }
        }
        return count;
    }
    
}