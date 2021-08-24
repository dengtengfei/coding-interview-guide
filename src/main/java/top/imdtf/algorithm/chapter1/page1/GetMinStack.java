package top.imdtf.algorithm.chapter1.page1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/23 21:57
 */
public class GetMinStack {
    public static void main(String[] args) {
//        Solution1 solution = new Solution1();
        Solution2 solution = new Solution2();
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt();
        scanner.nextLine();
        while (optCount-- > 0) {
            String opt = scanner.nextLine();
            if (opt.startsWith("push ")) {
                solution.push(Integer.parseInt(opt.substring(opt.lastIndexOf(' ') + 1)));
            } else if ("pop".equals(opt)) {
                solution.pop();
            } else if ("getMin".equals(opt)) {
                System.out.println(solution.getMin());
            } else {
                throw new RuntimeException("Unsupported operation.");
            }
        }
    }

    private static class Solution1 {
        private final Stack<Integer> stackData = new Stack<>(), stackMin = new Stack<>();

        public int getMin() {
            if (stackMin.empty()) {
                throw new RuntimeException("Stack is empty.");
            }
            return stackMin.peek();
        }

        public void push(int value) {
            stackData.push(value);
            if (stackMin.empty() || getMin() >= value) {
                stackMin.push(value);
            }
        }

        public int pop() {
            if (stackData.empty()) {
                throw new RuntimeException("Stack is empty.");
            }
            int value = stackData.pop();
            if (value == getMin()) {
                stackMin.pop();
            }
            return value;
        }
    }

    private static class Solution2 {
        private final Stack<Integer> stackData = new Stack<>(), stackMin = new Stack<>();

        public int getMin() {
            if (stackMin.empty()) {
                throw new RuntimeException("Stack is empty.");
            }
            return stackMin.peek();
        }

        public void push(int value) {
            stackData.push(value);
            if (stackMin.empty() || getMin() >= value) {
                stackMin.push(value);
            } else {
                stackMin.push(getMin());
            }
        }

        public int pop() {
            if (stackData.empty()) {
                throw new RuntimeException("Stack is empty.");
            }
            stackMin.pop();
            return stackData.pop();
        }
    }
}
