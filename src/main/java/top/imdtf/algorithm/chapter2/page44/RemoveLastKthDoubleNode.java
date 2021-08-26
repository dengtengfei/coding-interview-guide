package top.imdtf.algorithm.chapter2.page44;

import java.util.Scanner;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/26 23:22
 */
public class RemoveLastKthDoubleNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt(), k = scanner.nextInt(), index = 0;
        scanner.nextLine();
        DoubleNode node = new DoubleNode(0), nodeCur = node;
        while (index++ < optCount) {
            nodeCur.next = new DoubleNode(scanner.nextInt());
            nodeCur.next.last = nodeCur;
            nodeCur = nodeCur.next;
        }
        node.next.last = null;
        solution(node.next, optCount, k);
    }

    private static class DoubleNode {
        private final int value;
        private DoubleNode next;
        private DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    private static void solution(DoubleNode node, int size, int k) {
        DoubleNode nodeCur = node;
        if (size < k || k < 1) {
            print(node);
            return;
        }
        int count = size - k;
        while (count-- > 1) {
            nodeCur = nodeCur.next;
        }
        if (size == k) {
            node.next.last = null;
            print(node.next);
        } else {
            nodeCur.next = nodeCur.next.next;
            if (nodeCur.next != null) {
                nodeCur.next.last = nodeCur;
            }
            print(node);
        }
    }

    private static void print(DoubleNode doubleNode) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            stringBuilder.append(doubleNode.value).append(" ");
            if (doubleNode.next != null) {
                doubleNode = doubleNode.next;
            } else {
                break;
            }
        }
        stringBuilder.append('\n');
        while (doubleNode != null) {
            stringBuilder.append(doubleNode.value).append(" ");
            doubleNode = doubleNode.last;
        }
        System.out.println(stringBuilder);
    }
}
