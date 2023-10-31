package 链表相关.Q206_翻转链表;

public class Solution {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode reverseList(ListNode head) {


        if (head == null) return null;

        // 没有下边的方法好，空间复杂度为O(n)，下边的方法为O(1)
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            previous = new ListNode(current.val, previous);
            current = current.next;
        }

        return previous;


//        ListNode current = head;
//        ListNode previous = null;
//        ListNode next = null;
//
//        while (current != null) {
//            next = current.next;
//            current.next = previous;
//            previous = current;
//            current = next;
//        }
//
//        return previous;


    }


}
