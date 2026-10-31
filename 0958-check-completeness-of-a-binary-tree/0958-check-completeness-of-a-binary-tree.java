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

// class Solution {
//     public boolean isCompleteTree(TreeNode root) {        
//         return check(root);
//     }
//     private boolean check(TreeNode A){
//         if(A == null){return true;}
//         if(A.left == null && A.right != null){return false;}
//         return check(A.left)&&check(A.right);
//     }
// }

// class Solution {
//     public boolean isCompleteTree(TreeNode root) {   
//         if(root == null){return false;}     
//         TreeNode curr = root;
//         Queue<TreeNode> q = new ArrayDeque<>();
//         q.add(root);
//         while(!q.isEmpty()){
//         boolean isspace = false;
//             int n = q.size();
//             for(int i = 0; i<n; i++){
//                 TreeNode ele = q.poll();
//                 if((isspace && ele.left != null) || (isspace && ele.right != null)){
//                     return false;
//                 }
//                 if(ele.left == null || ele.right == null){
//                     isspace = true;
//                 }
//                  if(ele.left != null){
//                     q.offer(ele.left);
//                  }
//                  if(ele.right != null){
//                     q.offer(ele.right);
//                  }
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean isspace = false;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                if (isspace) return false;
                q.offer(curr.left);
            } else {
                isspace = true;
            }

            if (curr.right != null) {
                if (isspace) return false;
                q.offer(curr.right);
            } else {
                isspace = true;
            }
        }

        return true;
    }
}