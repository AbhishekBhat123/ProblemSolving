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
    boolean isfound = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        check(root, targetSum, 0);
        return isfound;
    }
    private void check(TreeNode root, int target, int sum){
        if(root == null){return;}
        if(root.left == null && root.right == null){
            if(sum + root.val == target){
                isfound = true;
            }
        }
        check(root.left, target, sum + root.val);
        check(root.right, target, sum + root.val);
    }
}