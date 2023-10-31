package 链表相关.Q21_合并两个有序链表;

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


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode temp = null;

        if (node1.val <= node2.val) {
            temp = node1;
            node1 = node1.next;
        } else {
            temp = node2;
            node2 = node2.next;
        }

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                temp.next = node1;
                temp = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                temp = node2;
                node2 = node2.next;
            }
        }

        if (node1 != null) temp.next = node1;
        if (node2 != null) temp.next = node2;

        return list1.val <= list2.val ? list1 : list2;
    }


}
