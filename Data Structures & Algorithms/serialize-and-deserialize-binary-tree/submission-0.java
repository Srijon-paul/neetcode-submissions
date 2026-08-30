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

public class Codec {
    List<String> st1 = new ArrayList<>();
    int start = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        fun1(root);
        return String.join(",", st1);
    }
    void fun1(TreeNode root){
        if(root == null){
            st1.add("N");
            return;
        }
        st1.add(String.valueOf(root.val));
        fun1(root.left);
        fun1(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        return fun2(vals);
    }
    TreeNode fun2(String[] vals){
        if(vals[start].equals("N")){
            start++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(vals[start]));
        start++;
        root.left = fun2(vals);
        root.right = fun2(vals);
        return root;
    }
}
