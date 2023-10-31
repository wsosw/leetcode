package 栈相关.Q232_用栈实现队列;

import java.util.Stack;

public class Solution {

    class MyQueue {

        Stack<Integer> stack1; // 栈1元素用来暂存进栈的元素
        Stack<Integer> stack2; // 栈2用来元素出队

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            // 栈2用来元素出队，如果栈2为空，就把栈1中的元素导进来
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }


}
