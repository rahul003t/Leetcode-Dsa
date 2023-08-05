/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Pair<Integer, Integer>, List<TreeNode>> dp; 
    public List<TreeNode> generateTrees(int n) {
        dp = new HashMap<>();
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> variations = new ArrayList<>();
        if (start > end) {
            variations.add(null);
            return variations;
        }
        if (dp.containsKey(new Pair<>(start, end))) {
            return dp.get(new Pair<>(start, end));
        }
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftSubTrees = helper(start, i - 1);
            List<TreeNode> rightSubTrees = helper(i + 1, end);
            for (TreeNode left: leftSubTrees) {
                for (TreeNode right: rightSubTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    variations.add(root);
                }
            }
        }
        dp.put(new Pair<>(start, end), variations);
        return variations;
    }   
}