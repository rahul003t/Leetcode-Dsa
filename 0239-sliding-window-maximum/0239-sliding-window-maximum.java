class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        for (int j = 0, i = 0; j < nums.length; j++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.offerLast(nums[j]);
            
            if (j - i + 1 == k) {
                result.add(deque.peekFirst());
                if (deque.peekFirst() == nums[i]) {
                    deque.pollFirst();
                }
                i++;
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}