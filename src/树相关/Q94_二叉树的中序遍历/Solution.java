package 树相关.Q94_二叉树的中序遍历;

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

    // 中序遍历：左根右
    public List<Integer> inorderTraversal(TreeNode root) {

        // 递归
        // ArrayList<Integer> res = new ArrayList<>();
        // inorder(root, res);
        // return res;


        // 迭代：利用栈
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }

    private void inorder(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        inorder(node.left, result); // 有左孩子节点就先遍历做孩子节点
        result.add(node.val);       // 没有了就输出当前节点值
        inorder(node.right, result);// 最后遍历右子树
    }


}
