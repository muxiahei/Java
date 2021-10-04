package HomeWork.Test01;

import java.util.Scanner;

/**
 * 【问题描述】
 *
 * 已知具有n个数组元素的一维数组A,请写一个算法，将该数组中所有值为0的元素都依次移到数组的前端，其他元素依次输出。
 * 【输入形式】
 *
 * 第一个数为输入数字的个数，其后为数组的数字
 * 【输出形式】
 *
 * 输出相应的数组
 * 【样例输入】
 *
 * 5 1 2 3 4 0
 * 【样例输出】
 *
 * 0 1 2 3 4
 */

public class ZeroForward {

    public static int[] solution1(int[] A) {
        int index = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                for(int j = i-1; j >= index; j--) {
                    A[j+1] = A[j];
                }
                A[index] = 0;
                index ++;
            }
        }
        return A;
    }

    public static int[] solution2(int[] A) {
        for(int i = 0; i < A.length - 1; i++) {
            for(int j = A.length - 1; j > i; j--) {
                if(A[j] == 0) {
                    A[j] = A[j-1];
                    A[j-1] = 0;
                }
            }
        }
        return A;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];

        for(int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        final int[] ints = solution1(array);

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
