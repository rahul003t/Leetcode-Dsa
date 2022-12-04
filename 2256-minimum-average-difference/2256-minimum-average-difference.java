class Solution {
    public int minimumAverageDifference(int[] nums) {
        
           ArrayList <Long> list = new ArrayList<Long>();
        
        long sum=0 , avg=0 , count=0;
        
        for(int i = 0 ; i<nums.length ;i++){
            sum+=nums[i];
        }
        
        
        for(int j =0; j <nums.length ; j++){
            count+=nums[j];
            if(nums.length-j-1==0){
                avg = Math.abs(((count)/(j+1)));
            }
            
            else{
                avg = Math.abs(((count)/(j+1))-((sum-count)/(nums.length-j-1)));
            }
            list.add(avg);
        }
        
        
        long min = Collections.min(list);
        for(int k=0 ; k < list.size() ; k++){
            
            if(list.get(k)==min){
                return k;
            }
        }
        return -1;
        
    }
}