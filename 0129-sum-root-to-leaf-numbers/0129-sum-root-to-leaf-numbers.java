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
    public int sumNumbers(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        
        if(root.right == null && root.left == null)
        {
            return root.val;
        }
        
        int ans = root.val;
        return check(root.left,ans)+check(root.right,ans);
    }
    
    public int check(TreeNode root, int sum)
    {
        if(root == null)
        {
            return 0;
        }
        
        if(root.left == null && root.right == null)
        {
            return sum=sum*10+root.val;
        }
        
        else
        {
            sum=sum*10+root.val;
            return check(root.left,sum)+check(root.right,sum);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}