package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,2,4,5,-4};

        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for(j = i-1; j >= 0; j--) {
                if(array[j] > temp) {
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
