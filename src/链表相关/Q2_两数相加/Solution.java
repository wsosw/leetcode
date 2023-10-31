package 链表相关.Q2_两数相加;


/**
 * 解题思路：
 *   1. 两数相加，可以使两个链表相同位置的元素相加，两个元素的模就是结果链表对应位置元素的值，两个元素除以10得到的商（carry）就是下一个元素的进位值
 *   2. 同时初始化结果链表的头指针和尾指针，头指针始终固定指向链表中的第一个元素，尾指针随着元素遍历同时向后移，始终指向最后一个元素
 */
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null; // 头指针
        ListNode tail = null; // 尾指针
        int carry = 0; // 进位数

        while (l1 != null || l2 != null) {

            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            if (head == null) {
                head = tail = new ListNode((n1 + n2) % 10, null);
            } else {
                tail.next = new ListNode((n1 + n2 + carry) % 10, null);
                tail = tail.next;
            }

            carry = (n1 + n2 + carry) / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) tail.next = new ListNode(carry, null);

        return head;
    }

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

    public static void main(String[] args) {

        ListNode ln3 = new ListNode(3, null);
        ListNode ln2 = new ListNode(4, ln3);
        ListNode ln1 = new ListNode(2, ln2);

        ListNode ln6 = new ListNode(4, null);
        ListNode ln5 = new ListNode(6, ln6);
        ListNode ln4 = new ListNode(5, ln5);

        ListNode node = addTwoNumbers(ln1, ln4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }



}
