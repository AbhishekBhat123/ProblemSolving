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
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    private int depth(TreeNode A){
        if(A == null){return 0;}
        int l = depth(A.left);
        int r = depth(A.right);
        return 1 + Math.max(l,r);
    }
}