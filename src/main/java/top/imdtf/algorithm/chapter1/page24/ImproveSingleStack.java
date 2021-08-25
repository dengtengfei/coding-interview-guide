package top.imdtf.algorithm.chapter1.page24;

import java.util.*;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/25 20:01
 */
public class ImproveSingleStack {
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
        Stack<List<Integer>> stack = new Stack<>();
        int[][] res = new int[data.size()][2];
        for (int i = 0; i < data.size(); ++i) {
            while (!stack.empty() && data.get(i) < data.get(stack.peek().get(0))) {
                List<Integer> values = stack.pop();
                for (Integer value : values) {
                    res[value][0] = stack.empty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                    res[value][1] = i;
                }
            }
            if (!stack.empty() && data.get(stack.peek().get(0)).equals(data.get(i))) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.empty()) {
            List<Integer> values = stack.pop();
            for (Integer value : values) {
                res[value][0] = stack.empty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                res[value][1] = -1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] item : res) {
            stringBuilder.append(item[0]).append(" ").append(item[1]).append('\n');
        }
        System.out.println(stringBuilder);
    }
}
