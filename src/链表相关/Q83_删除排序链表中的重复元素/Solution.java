package 链表相关.Q83_删除排序链表中的重复元素;

public class Solution {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        ListNode current = head;
        ListNode prev = head;

        while (current.next != null) {

            current = current.next;

            if (prev.val == current.val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
        }

        return head;



    }



}
