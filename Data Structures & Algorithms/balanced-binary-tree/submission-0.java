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

    static record Pair<T, U>(T first, U second){}

    public boolean isBalanced(TreeNode root) {
        return balanced(root).first();
    }

    public Pair<Boolean, Integer> balanced(TreeNode root) {
        if (root == null) return new Pair(true, 0);

        Pair<Boolean, Integer> left = balanced(root.left);
        Pair<Boolean, Integer> right = balanced(root.right);

        return new Pair(left.first() && right.first() && Math.abs(left.second() - right.second()) <= 1, 1 + Math.max(left.second(), right.second()));

    }
}
