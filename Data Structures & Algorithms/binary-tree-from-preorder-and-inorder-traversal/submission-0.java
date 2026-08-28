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
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return makeTree(preorder, 0, inorder.length - 1);
    }
    TreeNode makeTree(int[] preorder, int left, int right){
        if(left > right) return null;
        int value = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(value);
        int mid = map.get(value);
        root.left = makeTree(preorder, left, mid - 1);
        root.right = makeTree(preorder, mid + 1, right);
        return root;
    }
}
