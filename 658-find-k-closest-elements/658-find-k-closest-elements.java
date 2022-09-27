class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         
        // binary search to find right most index such that arr[l] < x
        int leftPtr = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                leftPtr = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // binary search to find left most index such that arr[r] > x
        int rightPtr = arr.length;
        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                rightPtr = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // everything between arr[l] and arr[r] should be = x
        // use 2 pointer technique to expand left and right bounds until we have k elements
        List<Integer> nums = new ArrayList<>();
        if (k - (rightPtr - leftPtr - 1) <= 0) {
            // if we already have k elements between left and right pointers, all of them will be = x
            for (int i = 0; i < k; i++) nums.add(x);
            return nums;
        } else {
            k -= (rightPtr - leftPtr - 1);
            while (k-- > 0) {
                if (leftPtr < 0 && rightPtr >= arr.length) { // break if pointers have reached array's left and right extremes
                    break;
                } else if (rightPtr >= arr.length) { // only reduce left pointer
                    leftPtr--;
                } else if (leftPtr < 0) {// only increase right pointer
                    rightPtr++;
                } else { // update the left or right pointer depending on distance
                    if (x - arr[leftPtr] <= arr[rightPtr] - x) leftPtr--;
                    else rightPtr++;    
                }
            }
            // add all numbers between left and right pointer to answer list
            for (int i = leftPtr + 1; i < rightPtr; i++) nums.add(arr[i]);
            return nums;
        }
    }
}