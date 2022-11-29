class Solution {
    public int removeDuplicates(int[] nums) {
//         int[] large = new int[nums.length];
//         int largest = Integer.MIN_VALUE;
//         int jdx =0;
//         for(int idx =0; idx <nums.length;idx++){
//             if(nums[idx] > largest){
//                 largest = nums[idx];
//                 large[jdx] = largest;
//                 jdx++;
//             }
//         }
        
//         for(int idx =0;idx<large.length;idx++){
//             nums[idx] = large[idx];
//         }
        
//         return jdx;
        
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[j] != nums[i])
            {
                nums[++j] = nums[i];
            }
        }
        
        return ++j;
    }
}