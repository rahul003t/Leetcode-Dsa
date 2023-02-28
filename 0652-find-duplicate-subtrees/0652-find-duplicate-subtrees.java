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
    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }    
    private String dfs(TreeNode node) {
        if (node == null) return "";
        var hash = dfs(node.left) + "-" + dfs(node.right) + "-" + node.val;
        if (map.getOrDefault(hash,0) == 1) result.add(node);
        map.merge(hash,1, Integer::sum);
        return hash;
    }
}