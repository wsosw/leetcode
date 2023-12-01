package 链表相关.Q143_重排链表;

import java.util.ArrayList;

/**
 * 题目描述：https://leetcode.cn/problems/reorder-list/description/
 * 难度等级：中等
 * 解题思路：链表的缺点就是不能随机访问，笨方法就是把链表元素放在arraylist中，利用线性表随机访问特性（索引下标）去修改链表元素的next指针
 * 复杂度分析：时间复杂度O(n)，空间复杂度O(n)
 *
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

    public void reorderList(ListNode head) {

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            list.get(i).next = list.get(list.size() - 1 - i);
            list.get(list.size() - 1 - i).next = list.get(i + 1);
        }

        list.get(list.size() / 2).next = null;


    }


}
