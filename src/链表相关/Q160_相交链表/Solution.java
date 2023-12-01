package 链表相关.Q160_相交链表;

// 难度等级：简单
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
     * 初始化两个指针pa和pb，pa用于循环链表a+b，pb用于循环链表b+a，他们的长度是相同的
     * 如果有相交节点，那么链表（a+b）和链表（b+a）从相交节点到最后的元素是相同的，即两个指针会在相交节点相遇
     * 如果没有相交节点，那么两个链表在循环完之后，返回null
     * @param headA 第一个链表
     * @param headB 第二个链表
     * @return 相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != null || pb != null) {

            if (pa == null) pa = headB;
            if (pb == null) pb = headA;

            if (pa == pb) return pa;

            pa = pa.next;
            pb = pb.next;
        }

        return null;

    }

}
