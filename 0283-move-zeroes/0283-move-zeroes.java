class Solution {
    public void moveZeroes(int[] nums) {
        
        int count=0;
        List<Integer> list = new ArrayList<>();
        
        for(int n: nums)
        {
            if(n ==0)
            {
                count++;
            }
            else
            {
                list.add(n);
            }
        }
        for(int i=0;i<count;i++)
        {
            list.add(0);
        }
        
        for(int j=0;j<nums.length;j++)
        {
            nums[j]=list.get(j);
        }
    }
}