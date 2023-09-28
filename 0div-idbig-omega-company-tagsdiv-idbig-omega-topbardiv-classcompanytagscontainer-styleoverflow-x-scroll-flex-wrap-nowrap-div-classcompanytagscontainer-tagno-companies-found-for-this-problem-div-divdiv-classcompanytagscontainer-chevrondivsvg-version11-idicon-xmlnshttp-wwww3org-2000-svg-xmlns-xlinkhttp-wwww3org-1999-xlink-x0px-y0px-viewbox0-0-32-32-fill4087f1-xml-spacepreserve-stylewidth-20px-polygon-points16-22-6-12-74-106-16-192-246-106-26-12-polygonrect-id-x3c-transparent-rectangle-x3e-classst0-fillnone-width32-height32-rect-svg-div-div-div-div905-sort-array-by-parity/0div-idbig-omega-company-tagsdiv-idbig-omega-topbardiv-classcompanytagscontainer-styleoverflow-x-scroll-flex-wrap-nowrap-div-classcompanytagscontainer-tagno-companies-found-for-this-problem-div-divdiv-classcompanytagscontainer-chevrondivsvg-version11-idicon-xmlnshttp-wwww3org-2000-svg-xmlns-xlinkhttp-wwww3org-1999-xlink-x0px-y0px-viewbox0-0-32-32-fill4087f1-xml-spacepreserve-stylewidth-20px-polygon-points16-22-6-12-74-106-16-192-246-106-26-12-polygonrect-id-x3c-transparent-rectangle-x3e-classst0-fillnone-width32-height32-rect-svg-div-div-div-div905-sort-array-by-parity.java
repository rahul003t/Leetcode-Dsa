class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        
        // Separate even and odd numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                evenNumbers.add(nums[i]);  // Even number found
            else
                oddNumbers.add(nums[i]);   // Odd number found
        }
        
        // Combine even and odd numbers, placing even numbers first
        for (int num : oddNumbers) {
            evenNumbers.add(num);
        }
        
        // Convert List to int[]
        int[] result = new int[evenNumbers.size()];
        for (int i = 0; i < evenNumbers.size(); i++) {
            result[i] = evenNumbers.get(i);
        }
        
        return result;  // Return the sorted array
    }
}