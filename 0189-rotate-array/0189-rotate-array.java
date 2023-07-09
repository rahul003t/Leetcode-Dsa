class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k%nums.length;
        
        reverseArray(nums,0,nums.length-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,nums.length-1);
        
        
        
    }
    
    public void reverseArray(int[] arr,int start,int end)
    {
        while(start < end)
        {
            int temp =  arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}