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
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> ans = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>(); 

        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode ele = q.poll();

                sum += ele.val;

                if (ele.left != null) q.offer(ele.left);
                if (ele.right != null) q.offer(ele.right);
            }
            double avg = sum/n;
            ans.add(avg);
        }

        return ans;
    }
}