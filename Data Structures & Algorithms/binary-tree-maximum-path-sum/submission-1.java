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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return res;
    }
    int maxPath(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(maxPath(root.left), 0);
        int rightSum = Math.max(maxPath(root.right), 0);
        int sum = root.val + leftSum + rightSum;
        res = Math.max(res, sum);
        return Math.max(leftSum + root.val, rightSum + root.val);
    }
}
