class Solution {
    public int[][] generateMatrix(int n) {
          
       int start=0;
        int end = n-1;
        int left=0;
        int right=n-1;
        int d=0;
        int number=1;
        int [][] matrix = new int[n][n];
        
        while(start<=end && left<=right ){
            if(d==0){
                
                for(int i=left;i<=right;i++){
                    matrix[start][i]=number;
                    number++; 
                } 
                start++;  
            }
           
        else if(d==1){
            for(int i=start;i<=end;i++){
                matrix[i][right]=number;
                number++;
            } 
            right--; 
        }
        else if(d==2){
            
            for(int i=right;i>=left;i--){
                matrix[end][i]=number;
                number++;
            }
            end--;
            
           
            
        }else if(d==3){
            for(int i=end;i>=start;i--){
                matrix[i][left]=number;
                number++;
            }
                
            left++;
        }
            
            
            d=(d+1)%4;
        }  
        return matrix;
    }
}


