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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        return addOneRow(root, val, depth, true);
    }
    
    public TreeNode addOneRow(TreeNode root, int val, int depth, boolean isLeft) {
        
        if(depth == 1) {
            TreeNode node = new TreeNode(val);
            
            if(isLeft) {
                node.left = root;
            }
            
            else {
                node.right = root;
            }
            return node;
        }
        else if(root == null) {
            return null;
        }
        
        root.left = addOneRow(root.left, val, depth-1, true);
        root.right = addOneRow(root.right, val, depth-1, false);
        
        return root;
    }
}