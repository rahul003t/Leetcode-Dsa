class Solution {
    public int maxArea(int[] height) {
        
        int maxArea = Integer.MIN_VALUE;
        int left=0;
        int right=height.length-1;
        
        
        while(left < right)
        {
            int shorterLine = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,shorterLine*(right-left));
            
            if(height[left] < height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        
        return maxArea;
        
    }
}