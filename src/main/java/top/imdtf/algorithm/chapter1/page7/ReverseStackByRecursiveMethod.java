package top.imdtf.algorithm.chapter1.page7;

import java.util.Scanner;
import java.util.Stack;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/23 22:16
 */
public class ReverseStackByRecursiveMethod {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt();
        scanner.nextLine();
        while (optCount-- > 0) {
            stack.push(scanner.nextInt());
        }
        new Solution<Integer>().reverse(stack);
        for (Integer num : stack) {
            System.out.print(num + " ");
        }
    }

    private static class Solution<T> {
        private T getAndRemoveLast(Stack<T> stack) {
            T value = stack.pop();
            if (stack.empty()) {
                return value;
            }
            T last = getAndRemoveLast(stack);
            stack.push(value);
            return last;
        }

        public void reverse(Stack<T> stack) {
            if (stack.empty()) {
                return;
            }
            T last = getAndRemoveLast(stack);
            reverse(stack);
            stack.push(last);
        }
    }
}
