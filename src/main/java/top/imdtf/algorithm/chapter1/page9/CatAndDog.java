package top.imdtf.algorithm.chapter1.page9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/23 22:26
 */
public class CatAndDog {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt();
        scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (optCount-- > 0) {
            String opt = scanner.nextLine();
            if (opt.startsWith("add ")) {
                String[] info = opt.split(" ", 2);
                solution.add(info[1]);
            } else if ("pollAll".equals(opt)) {
                while (!solution.isEmpty()) {
                    stringBuilder.append(solution.pollAll()).append("\n");
                }
            } else if ("pollCat".equals(opt)) {
                while (!solution.isCatEmpty()) {
                    stringBuilder.append(solution.pollCat()).append("\n");
                }
            } else if ("pollDog".equals(opt)) {
                while (!solution.isDogEmpty()) {
                    stringBuilder.append(solution.pollDog()).append("\n");
                }
            } else if ("isEmpty".equals(opt)) {
                stringBuilder.append(solution.isEmpty() ? "yes" : "no").append("\n");
            } else if ("isDogEmpty".equals(opt)) {
                stringBuilder.append(solution.isDogEmpty() ? "yes" : "no").append("\n");
            } else if ("isCatEmpty".equals(opt)) {
                stringBuilder.append(solution.isCatEmpty() ? "yes" : "no").append("\n");
            } else {
                throw new RuntimeException("Unsupported operation: " + opt);
            }
        }
        System.out.println(stringBuilder);
    }

    private static class Solution {
        private long count;
        private final Queue<Pet> catQueue = new LinkedList<>();
        private final Queue<Pet> dogQueue = new LinkedList<>();

        public void add(String type) {
            String dog = "dog";
            if (type.startsWith(dog)) {
                dogQueue.add(new Pet(type, count++));
            } else {
                catQueue.add(new Pet(type, count++));
            }
        }

        public Pet pollAll() {
            if (catQueue.isEmpty() && dogQueue.isEmpty()) {
                throw new RuntimeException("Queue is empty.");
            }
            if (catQueue.isEmpty()) {
                return dogQueue.poll();
            }
            if (dogQueue.isEmpty()) {
                return catQueue.poll();
            }
            return catQueue.peek().getEnterTime() <= dogQueue.peek().getEnterTime() ? catQueue.poll() : dogQueue.poll();
        }

        public Pet pollCat() {
            if (catQueue.isEmpty()) {
                throw new RuntimeException("Queue is empty.");
            }
            return catQueue.poll();
        }

        public Pet pollDog() {
            if (dogQueue.isEmpty()) {
                throw new RuntimeException("Queue is empty.");
            }
            return dogQueue.poll();
        }

        public boolean isEmpty() {
            return catQueue.isEmpty() && dogQueue.isEmpty();
        }

        public boolean isCatEmpty() {
            return catQueue.isEmpty();
        }

        public boolean isDogEmpty() {
            return dogQueue.isEmpty();
        }
    }

    private static class Pet {
        private final String type;
        private final long enterTime;

        public Pet(String type, long enterTime) {
            this.type = type;
            this.enterTime = enterTime;
        }

        public long getEnterTime() {
            return enterTime;
        }

        @Override
        public String toString() {
            return type;
        }
    }
}
