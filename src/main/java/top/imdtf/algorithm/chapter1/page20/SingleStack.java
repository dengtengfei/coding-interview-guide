package top.imdtf.algorithm.chapter1.page20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/25 20:01
 */
public class SingleStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt();
        scanner.nextLine();
        List<Integer> data = new ArrayList<>(optCount);
        while (optCount-- > 0) {
            data.add(scanner.nextInt());
        }
        solution(data);
    }

    private static void solution(List<Integer> data) {
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[data.size()][2];
        for (int i = 0; i < data.size(); ++i) {
            while (!stack.empty() && data.get(i) < data.get(stack.peek())) {
                int value = stack.pop();
                res[value][0] = stack.empty() ? -1 : stack.peek();
                res[value][1] = i;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int value = stack.pop();
            res[value][0] = stack.empty() ? -1 : stack.peek();
            res[value][1] = -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] item : res) {
            stringBuilder.append(item[0]).append(" ").append(item[1]).append('\n');
        }
        System.out.println(stringBuilder);
    }
}
