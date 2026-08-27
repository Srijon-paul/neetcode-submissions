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
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p.val < q.val){
            lca(root, p, q);
        }else{
            lca(root, q, p);
        }
        return ans;
    }
    void lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return;
        }
        if(root == p || root == q){
            ans = root;
            return;
        }
        if(root.val < p.val){
            lca(root.right, p, q);
        }else if(root.val > q.val){
            lca(root.left, p, q);
        }else{
            ans = root;
            return;
        }
    }
}
