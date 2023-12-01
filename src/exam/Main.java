package exam;

public class Main {

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


    public ListNode mergeNode(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode prev = head;
        ListNode curr = head.next;

        if (curr.val % 2 == 0 && prev.val % 2 == 1) {// 当碰到偶数时，只有前一个节点值为奇数，才进行合并，否则不合并
            prev.val = prev.val + curr.val;
            prev.next = curr.next;
            prev = mergeNode(prev);
        } else {
            prev.next = mergeNode(curr);
        }

        return head;
    }


    public static void main(String[] args) {

//        ListNode list = new ListNode(2, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(8, new ListNode(7))))));
        ListNode list = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(6, new ListNode(8, new ListNode(7))))));
        ListNode head = new Main().mergeNode(list);

        System.out.println(head);

    }


}
