package HomeWork.Test02;

import java.util.*;

/**
 * 设将n（n>1）个整数存放在一维数组R中。试设计一个在时间和空间两方面都尽可能高效的算法。将R中保存的序列循环左移P（P>0）个位置。
 * 例如，假设P<n，将R中的数据（X0,X1,..Xn-1）循环左移P个位置后，变换为（Xp, XP+1,..Xn-1,X0,X1,..Xp-1）
 * 【输入形式】
 *
 * 循环移动的位数，数组中数据的个数，循环前的数组
 * 【输出形式】
 *
 * 循环后的数组
 * 【样例输入】
 *
 * 3 5 1 2 3 4 5
 * 【样例输出】
 *
 * 4 5 1 2 3
 * 【样例说明】
 */
public class RotateLeft {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();
        int num = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < num; i++) {
            queue.add(scanner.nextInt());
        }
        for(int i = 0; i < times; i++) {
            final Integer remove = queue.remove();
            queue.add(remove);
        }

        final Iterator<Integer> iterator = queue.iterator();

        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            System.out.print(next + " ");
        }
    }
}
