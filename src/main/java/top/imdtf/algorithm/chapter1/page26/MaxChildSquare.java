package top.imdtf.algorithm.chapter1.page26;

import java.util.*;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/25 20:38
 */
public class MaxChildSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCount = scanner.nextInt(), columnCount = scanner.nextInt();
        scanner.nextLine();
        int[][] data = new int[rowCount][columnCount];
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                data[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(data));
    }

    private static int solution(int[][] data) {
        int maxArea = 0;
        if (data == null || data.length == 0 || data[0].length == 0) {
            return maxArea;
        }
        int[] height = new int[data[0].length];
        for (int[] datum : data) {
            for (int j = 0; j < datum.length; ++j) {
                height[j] = datum[j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, getBigThanNear(height));
        }
        return maxArea;
    }

    public static int getBigThanNear(int[] data) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < data.length; ++i) {
            while (!stack.empty() && data[i] < data[stack.peek()]) {
                int values = stack.pop();
                int start = stack.empty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - start - 1) * data[values]);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int values = stack.pop();
            int start = stack.empty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (data.length - start - 1) * data[values]);
        }
        return maxArea;
    }
}
