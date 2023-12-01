package exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CCBFintechExam {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 编程题目一
    public ListNode solve(ListNode head) {
        // write code here
        if (head == null) return null;
        if (head.next == null) return head;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            if (!hashMap.containsKey(curr.val)) {
                hashMap.put(curr.val, 1);
            } else {
                hashMap.put(curr.val, hashMap.get(curr.val) + 1);
            }
            curr = curr.next;
        }

        int maxKey = Integer.MIN_VALUE;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        ListNode newHead = null;
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            if (current.val == maxKey) {
                if (previous == null) {
                    newHead = current;
                    previous = current;
                } else {
                    previous.next = current;
                    previous = current;
                }
            }
            current = current.next;
        }
        if (previous != null) {
            previous.next = null;
        }

        return newHead;
    }

//    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(1)))));
//        new CCBFintechExam().solve(head);
//    }


    // 编程题目二
    public boolean isred(String s) {
        // write code here

        if (s == null || "".equals(s)) return false;
        if (s.length() < 3) return false;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'r' || s.charAt(i) != 'e' || s.charAt(i) != 'd') {
                return false;
            }

            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), 1);
            } else {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            }

        }

        int rCount = hashMap.getOrDefault('r', 0);
        int eCount = hashMap.getOrDefault('e', 0);
        int dCount = hashMap.getOrDefault('d', 0);


        return (rCount == dCount) && (eCount == dCount);

    }


}
