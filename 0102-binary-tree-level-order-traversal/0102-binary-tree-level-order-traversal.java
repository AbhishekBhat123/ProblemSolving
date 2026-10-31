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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){return new ArrayList<>();}
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer>out = new ArrayList<>();
            for(int i =0; i<n; i++){
                TreeNode ele = q.poll();
                out.add(ele.val);
                if(ele.left != null){q.offer(ele.left);}
                if(ele.right != null){q.offer(ele.right);}
            }
            ans.add(out);
        }
        return ans;
    }
}