package HomeWork.Test01;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class NumFrequencyDistribution {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            int[] array = new int[]{0,0,0,0,0,0,0,0,0,0};
            for(int i = 1; i <= num; i++) {
                int j = i;
                while(j > 0) {
                    int oneIndex = j % 10;
                    array[oneIndex]++;
                    j = j / 10;
                }
            }
            for(int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }catch (NoSuchElementException e){

        }

    }
}
