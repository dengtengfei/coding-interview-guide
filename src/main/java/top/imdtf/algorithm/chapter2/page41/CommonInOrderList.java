package top.imdtf.algorithm.chapter2.page41;

import java.util.Scanner;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/26 22:34
 */
public class CommonInOrderList {
    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt();
        scanner.nextLine();
        Node node1 = new Node(0), node2 = new Node(0), node11 = node1, node22 = node2;
        while (optCount-- > 0) {
            node11.next = new Node(scanner.nextInt());
            node11 = node11.next;
        }
        optCount = scanner.nextInt();
        while (optCount-- > 0) {
            node22.next = new Node(scanner.nextInt());
            node22 = node22.next;
        }
        solution(node1.next, node2.next);
    }

    private static void solution(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (node1 != null && node2 != null) {
            if (node1.getValue() < node2.getValue()) {
                node1 = node1.next;
            } else if (node1.getValue() > node2.getValue()) {
                node2 = node2.next;
            } else {
                stringBuilder.append(node1.value).append(" ");
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        System.out.println(stringBuilder);
    }
}
