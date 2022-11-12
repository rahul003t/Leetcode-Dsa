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
    int leftLeaveSum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        
        helper(root);
        return leftLeaveSum;
        
    }
    
    private void helper(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        if(isLeaveNode(root.left))
        {
            leftLeaveSum += root.left.val;
        }
        helper(root.right);
        helper(root.left);
    }
    
    private boolean isLeaveNode(TreeNode root)
    {
        if(root == null)
        {
            return false;
        }
        if(root.left == null && root.right == null)
        {
            return true;
        }
        return false;
    }
}