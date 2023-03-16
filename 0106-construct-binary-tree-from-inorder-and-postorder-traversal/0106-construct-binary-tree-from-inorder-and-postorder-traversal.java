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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder == null || postorder == null || inorder.length != postorder.length){
            return null;
        }

        int n = inorder.length;
        int inStart = 0;
        int inEnd = n-1;

        int postStart = 0;
        int postEnd = n-1;

        return solve(inorder,inStart,inEnd,postorder,postStart,postEnd);


    }

    TreeNode solve(int[] inorder,int inStart,int inEnd , int[] postorder ,int postStart, int postEnd)
    {

        if(inStart > inEnd || postStart >  postEnd){
            return null;
        }


        TreeNode root = new TreeNode( postorder[postEnd] );

        int i = inStart;

        for(;i<=inEnd;i++){
            if(inorder[i] == root.val){
                break;
            }
        }

        int leftSize = i - inStart;
        int rightSize = inEnd - i;

        root.left = solve(inorder,inStart,i-1,postorder,postStart,postStart + leftSize -1);
        root.right = solve(inorder,i+1,inEnd,postorder,postEnd - rightSize,postEnd-1);

        return root;

    }
}