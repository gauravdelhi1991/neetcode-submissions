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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        smallest(root, k, result);
        return result.get(result.size() - 1);
    }

    private void smallest(TreeNode root, int k, List<Integer> result) {
        if (result.size() < k && root.left != null) {
            smallest(root.left, k, result);
        }
        if (result.size() == k) return;
        result.add(root.val);
        if (result.size() < k && root.right != null) {
            smallest(root.right, k, result);
        }
    }
}
