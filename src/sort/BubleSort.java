package sort;

import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {

        int[] array = new int[]{3,1,2,4,5};

        for(int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }

        System.out.println(Arrays.toString(array));


    }
}
