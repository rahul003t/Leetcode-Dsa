class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n>flowerbed.length){
            return false;
        }
        if(n==0)
            return true;
            
        if(flowerbed.length==1 && n==1 && flowerbed[0]==0)
            return true;
        if(flowerbed.length==1 && n==1 && flowerbed[0]==1)
            return false;
        if(flowerbed.length==1 && n>1 )
            return false;
        if(flowerbed[flowerbed.length-1]==0&&flowerbed[flowerbed.length-2]==0){
            flowerbed[flowerbed.length-1]=1;
            n=n-1;
        }    
        if(n==1 && flowerbed[0]==0&&flowerbed[1]==0)
            return true;   
             
        boolean dp[][] = new boolean[flowerbed.length+1][n+1];
        return function(flowerbed.length-1,flowerbed,n,dp);
    }

    public boolean function(int index,int[]arr,int n,boolean dp[][]){
        if(n==0)return true;
        if(n==1&&index==0){
            if(arr[index]==0&&arr[index+1]==0){
                return true;
            }else{
                return false;
            }
        }
        if(index==0&&n>0)return false;
        if(index==0&&n==0)return true;
        
        if(dp[index][n]==true)return true;
        boolean plant = false;
        boolean notPlant = false;
        
        if(index+1<arr.length &&arr[index-1]==0&&arr[index+1]==0&&arr[index]==0&&index-1>=0&&index>=0){
            arr[index]=1;
            plant = function(index-1,arr,n-1,dp);
        }
        else{
            notPlant = function(index-1,arr,n,dp);
        }

        return dp[index][n] = plant||notPlant;
    }
}