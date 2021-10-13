package LeedCode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test_189 {
    public static int[] rotate(int[] nums, int k) {

        if(k > nums.length) {
            k = k % nums.length;
        }

        Queue a = new LinkedList();
        for(int i = 0; i < nums.length; i++) {
            a.add(nums[i]);
        }
        for(int i = 0; i < nums.length-k; i++) {
            int num = (int)a.remove();
            a.add(num);
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i]= (int)a.remove();
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        final int[] rotate = rotate(array, 3);
        System.out.println(Arrays.toString(array));

    }
}
