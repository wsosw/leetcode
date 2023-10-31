package 树相关.Q662_二叉树最大宽度;

import javafx.util.Pair;

import java.util.LinkedList;

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

    public int widthOfBinaryTree(TreeNode root) {

        int maxWidth = 0;

        if (root == null) return maxWidth;

        // 层序遍历，给每一层的每个元素都标号，最后最右边的减最左边的就能求每一层的宽度
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));

        while (!queue.isEmpty()) {

            int size = queue.size();
            int left = queue.peek().getValue();
            int right = left;

            while (size > 0) {

                Pair<TreeNode, Integer> poll = queue.poll();

                if (poll != null) {
                    right = poll.getValue();
                    TreeNode node = poll.getKey();
                    if (node.left != null) queue.add(new Pair<>(node.left, right * 2 - 1));
                    if (node.right != null) queue.add(new Pair<>(node.right, right * 2));
                }
                size--;
            }

            maxWidth = Math.max(maxWidth, right - left + 1);
        }

        return maxWidth;
    }


}
