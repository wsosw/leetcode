package 链表相关.Q141_环形链表;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 题目描述：https://leetcode.cn/problems/linked-list-cycle/description/
 * 难度等级：简单
 * 解题思路：初始化一个map，用node.val做key，val相同的节点存在一起，然后每个节点进来时用==判断有没有相同节点，有就代表有环
 * 复杂度分析：时间复杂度O(n)，空间复杂度O(n)
 */
public class Solution {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        HashMap<Integer, ArrayList<ListNode>> hashMap = new HashMap<>();
        ListNode curr = head;

        while (curr != null) {
            if (!hashMap.containsKey(curr.val)) {
                ArrayList<ListNode> nodes = new ArrayList<>();
                nodes.add(curr);
                hashMap.put(curr.val, nodes);
            } else {
                for (ListNode node : hashMap.get(curr.val)) {
                    if (curr == node) {
                        return true;
                    }
                }
                hashMap.get(curr.val).add(curr);
            }

            curr = curr.next;
        }

        return false;

    }


}
