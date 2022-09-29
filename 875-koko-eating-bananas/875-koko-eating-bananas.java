class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max =0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int start =0;
        int end = max;
        int res =0;
        
        while(start <= end){
            int mid = start +(end - start)/2;
            if(hours(piles,mid,h)){
                res= mid;
                end = mid - 1;
            }else{
                start = mid+1;
            }
        }
        
        return res;
        
    }
   public  boolean hours(int []arr, int a,int h){
        int total=0;
        for(int i=0;i<arr.length;i++){
            total+= Math.ceil(arr[i]*1.0/a);
            
        }
        return total<=h;
    }
}