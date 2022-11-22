
class Solution {
  public void sortColors(int[] nums) {
    // int zeroIdx = 0;
    // int twoIdx = nums.length - 1;
    // for (int i = 0; i <= twoIdx; ) {
    //   if (nums[i] == 0 && i != zeroIdx) {
    //     int temp = nums[zeroIdx];
    //     nums[zeroIdx++] = nums[i];
    //     nums[i] = temp;
    //   } else if (nums[i] == 2 && i != twoIdx) {
    //     int temp = nums[twoIdx];
    //     nums[twoIdx--] = nums[i];
    //     nums[i] = temp;
    //   } else {
    //     i++;
    //   }
    // }
      
    // Arrays.sort(nums);
      
      for(int i=0;i<nums.length;i++){
          for(int j=1;j<nums.length-i;j++){
              if(nums[j] < nums[j-1]){
                  int temp = nums[j];
                  nums[j]= nums[j-1];
                  nums[j-1] = temp;
                 
              }
          }
      }
    }
}