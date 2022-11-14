class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     
//         int[] ngr= nextGreaterRight(nums1);
        
//         HashMap<Integer,Integer> hm = new HashMap<>();
        
//         for(int i=0;i<nums1.length;i++)
//         {
//             hm.put(nums1[i],ngr[i]);
//         }
        
//         int[] ans = new int[nums2.length];
//         for(int i=0;i<nums2.length;i++)
//         {
//             ans[i] = hm.get(nums2[i]);
//         }
     
        
//         return ans;
        
//     }
    
//     int[] nextGreaterRight(int[] nums)
//     {
//         Stack <Integer> stack = new Stack<>();
      
//         int[] ans = new int[nums.length];
        
//         for(int i= nums.length-1;i>=0;i--)
//         {
//             while(stack.size() > 0 && stack.peek() < nums[i])
//             {
//                 stack.pop();
//             }
//             ans[i] = stack.size() > 0? stack.peek():-1;
//             stack.push(nums[i]);
//         }
        
//         return ans;
        
        int[] ans = new int[nums1.length];
        Arrays.fill(ans,-1);
        
        HashMap <Integer,Integer> hm = new HashMap<>();
        
        for(int j=0;j<nums2.length;j++)
        {
            hm.put(nums2[j],j);
        }
        
        for(int i=0;i<nums1.length;i++)
        {
            int m = hm.get(nums1[i]);
            for(int j=m;j<nums2.length;j++)
            {
                if(nums2[j] > nums1[i])
                {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
        
   }
}