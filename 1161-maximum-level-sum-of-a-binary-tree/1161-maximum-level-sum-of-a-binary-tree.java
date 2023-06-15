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
    public int maxLevelSum(TreeNode root) {
        int levelsum = Integer.MIN_VALUE;
        Queue<TreeNode> mq = new ArrayDeque<>();
        Queue<TreeNode> hq = new ArrayDeque<>();
        int currval = 0;
        int level = 0;
        int increment = 1;
        mq.add(root);
        while(mq.size()>0){
            TreeNode temp  = mq.remove();
            currval += temp.val;
            if(temp.left!=null)hq.add(temp.left);
            if(temp.right!=null)hq.add(temp.right);
            if(mq.size()==0){
                if(currval > levelsum){
                    level = increment;
                    levelsum = currval;
                }
                Queue<TreeNode> t = mq;
                mq = hq;
                hq = t;
                increment += 1;
                currval = 0;
            }
        }
        return level;
        
    }
}