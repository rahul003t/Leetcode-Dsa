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
    List<List<TreeNode>> dp = new ArrayList<>();
    
    List<TreeNode> solve(int n) {
        if (n % 2 == 0)
            return new ArrayList<>();
        
        if (!dp.get(n).isEmpty())
            return dp.get(n);
        
        if (n == 1) {
            TreeNode new_node = new TreeNode(0);
            List<TreeNode> result = new ArrayList<>();
            result.add(new_node);
            return result;
        }
        
        List<TreeNode> res = new ArrayList<>();
        
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = solve(i);
            List<TreeNode> right = solve(n - i - 1);
            
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        
        dp.set(n, res);
        return res;
    }
    
    public List<TreeNode> allPossibleFBT(int n) {
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        return solve(n);
    }
}