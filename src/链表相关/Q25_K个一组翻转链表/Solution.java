package 链表相关.Q25_K个一组翻转链表;

import java.util.ArrayList;

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

    /**
     * 解题思路：
     *   1. 首先把每k个元素为一组，对每组元素进行翻转。
     *   2. 然后把每组的头和尾单独拿出来，使前一组的尾指向后一组的头。
     *   3. 最后对最后一组的尾部元素单独处理，防止出现死循环
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;

        ArrayList<ListNode> tailList = new ArrayList<>();
        ArrayList<ListNode> headList = new ArrayList<>();

        while (count >= k) {

            // 每k个元素进行一次翻转
            for (int i = 0; i < k; i++) {

                if (i == 0) tailList.add(curr);
                if (i == k - 1) headList.add(curr);

                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            count -= k;
        }

        for (int i = 0; i < tailList.size() - 1; i++) {
            tailList.get(i).next = headList.get(i + 1);
        }
        if (count > 0) {
            tailList.get(tailList.size() - 1).next = temp;
        } else {
            tailList.get(tailList.size() - 1).next = null;
        }

        return headList.get(0);
    }


    public static void main(String[] args) {

        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = new Solution().reverseKGroup(node, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }



}
