class Solution {
    public int singleNumber(int[] nums) {
//         int ones =0;
//         int twos=0;
//         for(int i=0;i<nums.length;i++)
//         {
//             ones = (ones ^ nums[i])& ~twos;
//             twos = (twos ^ nums[i])& ~ones;
//         }
        
//         return ones;
        
        
        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(map.get(nums[i]) ==1)
            {
                ans = nums[i];
            }
        }
        
        return ans;
        }
     
    }