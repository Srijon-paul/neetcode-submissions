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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean valid(TreeNode root, int leftval, int rightval){
        if(root == null){
            return true;
        }
        if(!(root.val < rightval && root.val > leftval)){
            return false;
        }
        return valid(root.left, leftval, root.val) && valid(root.right, root.val, rightval);
    }
}
