package 树相关.Q102_二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        // 利用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();

            while (size > 0) {
                TreeNode polled = queue.poll();
                if (polled != null) {
                    tmp.add(polled.val);
                    if (polled.left != null) queue.add(polled.left);
                    if (polled.right != null) queue.add(polled.right);
                }
                size--;
            }
            res.add(tmp);

        }
        return res;
    }




}
