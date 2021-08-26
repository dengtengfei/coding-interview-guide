package top.imdtf.algorithm.chapter2.page42;

import java.util.Scanner;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/26 23:22
 */
public class RemoveLastKthSingleNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt(), k = scanner.nextInt(), index = 0;
        scanner.nextLine();
        Node node = new Node(0), node1 = node;
        while (index++ < optCount) {
            node1.next = new Node(scanner.nextInt());
            node1 = node1.next;
        }
        solution(node.next, optCount, k);
    }

    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void solution(Node node, int size, int k) {
        Node node1 = node;
        if (size < k || k < 1) {
            print(node);
            return;
        }
        int count = size - k;
        while (count-- > 1) {
            node1 = node1.next;
        }
        if (size == k) {
            print(node.next);
        } else {
            node1.next = node1.next.next;
            print(node);
        }
    }

    private static void print(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.value).append(" ");
            node = node.next;
        }
        System.out.println(stringBuilder);
    }
}
