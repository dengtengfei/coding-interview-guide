package top.imdtf.algorithm.chapter1.page33;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/26 22:24
 */
public class CountOfMountWhichCanSee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optCount = scanner.nextInt();
        List<Integer> data = new ArrayList<>(optCount);
        scanner.nextLine();
        while (optCount-- > 0) {
            data.add(scanner.nextInt());
        }
        System.out.println(solution(data));
    }

    private static int solution(List<Integer> data) {
        if (data.isEmpty() || data.size() < 2) {
            return 0;
        }
        // TODO can not understand
        return 2 * data.size() - 3;
    }
}
