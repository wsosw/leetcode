package 队列相关.Q225_用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    class MyStack {

        // 两个队列交替使用，哪个有元素哪个就当栈
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            if (queue1.isEmpty()) {
                queue1.offer(x);
                while (!queue2.isEmpty()) {
                    queue1.offer(queue2.poll());
                }
            } else {
                queue2.offer(x);
                while (!queue1.isEmpty()) {
                    queue2.offer(queue1.poll());
                }
            }
        }

        public int pop() {
            int top = 0;
            if (!queue1.isEmpty()) {
                top = queue1.poll();
            } else if (!queue2.isEmpty()){
                top = queue2.poll();
            }
            return top;
        }

        public int top() {
            int top = 0;
            if (!queue1.isEmpty()) {
                top = queue1.peek();
            } else if (!queue2.isEmpty()){
                top = queue2.peek();
            }
            return top;
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }



}
