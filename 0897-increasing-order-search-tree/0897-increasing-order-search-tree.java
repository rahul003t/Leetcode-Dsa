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
    
    TreeNode newNode = new TreeNode(-1);
    TreeNode curr = newNode;
    
    
    public void inorder(TreeNode root)
    {
        if(root == null)
        {
            return ;
        }
        
        inorder(root.left);
        TreeNode newN = new TreeNode(root.val);
        curr.right = newN;
        curr = curr.right;
        inorder(root.right);
        
        
    }
    public TreeNode increasingBST(TreeNode root) {
        
        inorder(root);
        
        return newNode.right;
    }
}