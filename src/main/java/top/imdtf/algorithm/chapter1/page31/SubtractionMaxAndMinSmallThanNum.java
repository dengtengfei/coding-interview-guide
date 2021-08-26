package top.imdtf.algorithm.chapter1.page31;

import java.util.*;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/25 23:13
 */
public class SubtractionMaxAndMinSmallThanNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt(), num = scanner.nextInt();
        List<Integer> data = new ArrayList<>(optCount);
        scanner.nextLine();
        while (optCount-- > 0) {
            data.add(scanner.nextInt());
        }
        System.out.println(solution(data, num));
    }

    private static int solution(List<Integer> data, int num) {
        // TODO can not understand
        if (data == null || data.size() == 0 || num < 0) {
            return 0;
        }
        int count = 0, i = 0, j = 0;
        Deque<Integer> dequeMin = new LinkedList<>(), dequeMax = new LinkedList<>();
        while (i < data.size()) {
            while (j < data.size()) {
                if (dequeMin.isEmpty() || dequeMin.peekLast() != j) {
                    while (!dequeMin.isEmpty() && data.get(dequeMin.peekLast()) >= data.get(j)) {
                        dequeMin.pollLast();
                    }
                    dequeMin.addLast(j);
                    while (!dequeMax.isEmpty() && data.get(dequeMax.peekLast()) <= data.get(j)) {
                        dequeMax.pollLast();
                    }
                    dequeMax.addLast(j);
                }
                if (data.get(dequeMax.getFirst()) - data.get(dequeMin.getFirst()) > num) {
                    break;
                }
                ++j;
            }
            count += j - i;
            if (dequeMin.peekFirst() == i) {
                dequeMin.pollFirst();
            }
            if (dequeMax.peekFirst() == i) {
                dequeMin.pollFirst();
            }
            ++i;
        }
        return count;
    }
}
