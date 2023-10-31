package 树相关.Q144_二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


    // 前序遍历：根左右
    public List<Integer> preorderTraversal(TreeNode root) {

        // 递归
        // ArrayList<Integer> res = new ArrayList<>();
        // preorder(root, res);
        // return res;


        // 遍历
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode current = stack.pop();
            res.add(current.val);

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

        }


        return res;
    }

    private static void preorder(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }


}
