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
    int res = 0;
    public int goodNodes(TreeNode root) {
        fun(root, root.val);
        return res;
    }
    void fun(TreeNode node, int max){
        if(node == null){
            return;
        }
        if(node.val >= max){
            max = Math.max(max, node.val);
            res += 1;
        }
        fun(node.left, max);
        fun(node.right, max);
        return;
    }
}
