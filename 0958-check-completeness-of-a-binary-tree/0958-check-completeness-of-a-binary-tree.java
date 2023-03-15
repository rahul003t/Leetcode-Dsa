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
    public boolean isCompleteTree(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
        
//         while(q.peek()!=null)
//         {
//             TreeNode curr = q.poll();
//             q.offer(curr.left);
//             q.offer(curr.right);
//         }
        
//         while(!q.isEmpty() && q.peek() == null)
//         {
//             q.poll();
//         }

//         return q.isEmpty();
        
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.peek()!=null){
            TreeNode curr = q.poll();
            q.offer(curr.left);
            q.offer(curr.right);
        }   
        while(!q.isEmpty() && q.peek()==null)
            q.poll();
        return q.isEmpty();  
    }
}