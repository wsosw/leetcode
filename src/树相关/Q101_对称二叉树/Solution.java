package 树相关.Q101_对称二叉树;

public class Solution {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isSymmetric(TreeNode root) {

        // 利用递归，每个节点都判断是否相等，只要出现不等，就返回false
        return symmetry(root, root);


    }

    private boolean symmetry(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        boolean res1 = node1.val == node2.val;
        boolean res2 = symmetry(node1.left, node2.right);
        boolean res3 = symmetry(node1.right, node2.left);

        return res1 && res2 && res3;
    }



}
