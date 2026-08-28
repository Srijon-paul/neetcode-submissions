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
    int c = 0;
    int ans = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        c = k;
        fun(root);
        return ans;
    }
    void fun(TreeNode node){
        if(node == null){
            return;
        }
        fun(node.left);
        c--;
        if(c == 0){
            ans = node.val;
        }
        fun(node.right);
    }
}
