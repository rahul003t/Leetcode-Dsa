class Solution {
    public int[] sortedSquares(int[] nums) {
        
        
//         Arrays.sort(nums);
        
//         //int arr = new int[nums.length];
        
        
//         int sqr=1;
//         for(int i=0;i<nums.length;i++){
//             nums[i]*=nums[i];
           
           
//         }
        
//         int[] arr = new int[nums.length];
//        for(int i=0;i<arr.length;i++){
//            System.out.println(Arrays.toString(arr));
//        }
        
//      0   return arr;
        
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = Math.abs(nums[i]);
        }
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++)
        {
            nums[i] *= nums[i]; 
        }
       
        
        return nums;
    }
}