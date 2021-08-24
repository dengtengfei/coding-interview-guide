package top.imdtf.algorithm.chapter1.page5;

import java.util.Scanner;
import java.util.Stack;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/23 22:07
 */
public class QueueByStack {
    public static void main(String[] args) {
//        Solution1<Integer> solution = new Solution1<>();
        Solution2<Integer> solution = new Solution2<>();
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt();
        scanner.nextLine();
        while (optCount-- > 0) {
            String opt = scanner.nextLine();
            if (opt.startsWith("add ")) {
                solution.push(Integer.parseInt(opt.substring(opt.lastIndexOf(' ') + 1)));
            } else if ("poll".equals(opt)) {
                solution.pop();
            } else if ("peek".equals(opt)) {
                System.out.println(solution.peek());
            } else {
                throw new RuntimeException("Unsupported operation.");
            }
        }
    }

    private static class Solution1<T> {
        private final Stack<T> stackPush = new Stack<>();
        private final Stack<T> stackPop = new Stack<>();

        public void push(T value) {
            while (!stackPop.empty()) {
                stackPush.push(stackPop.pop());
            }
            stackPush.push(value);
        }

        public T pop() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty.");
            }
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }

        public T peek() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty.");
            }
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
            return stackPop.peek();
        }
    }

    private static class Solution2<T> {
        private final Stack<T> stackPush = new Stack<>();
        private final Stack<T> stackPop = new Stack<>();

        private void push2Pop() {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void push(T value) {
            stackPush.push(value);
            push2Pop();
        }

        public T pop() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty.");
            }
            push2Pop();
            return stackPop.pop();
        }

        public T peek() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty.");
            }
            push2Pop();
            return stackPop.peek();
        }
    }
}
