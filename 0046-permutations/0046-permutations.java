class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        helper(new ArrayList<>(), nums);
        return result;
    }
    
    public void helper(List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int num: nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                helper(curr, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}