package 树相关.Q145_二叉树的后序遍历;

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


    // 前序遍历：左右根
    public List<Integer> postorderTraversal(TreeNode root) {

        // 递归
        // ArrayList<Integer> res = new ArrayList<>();
        // postorder(root, res);
        // return res;


        // 遍历
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return result;


    }

    private void postorder(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }


}
