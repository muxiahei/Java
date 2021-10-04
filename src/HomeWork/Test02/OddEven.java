package HomeWork.Test02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class OddEven {

    static void solution1(String[] array) {
        int[] result = new int[array.length];

        int j = array.length - 1;
        int k = 0;

        for (int i = 0; i < array.length; i++) {
            if(j < k) {
                break;
            }
            if(Integer.valueOf(array[i]) % 2 == 0) {
                result[j] = Integer.valueOf(array[i]);
                j--;
            }else{
                result[k] = Integer.valueOf(array[i]);
                k++;
            }
        }
        for(int i = 0; i< result.length; i++) {
            System.out.print(result[i]);
            if(i < result.length - 1) {
                System.out.print(",");
            }
        }
    }

    static void solution2(String[] array) {
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();

        for (int i = 0; i < array.length; i++) {
            if(Integer.valueOf(array[i]) % 2 == 0) {
                even.add(array[i]);
            }else{
                odd.add(array[i]);
            }
        }

        final Iterator oddIterator = odd.iterator();
        final Iterator evenIterator = even.iterator();

        boolean flag = false;
        if(oddIterator.hasNext()){
            flag = true;
        }
        while (oddIterator.hasNext()){
            System.out.print(oddIterator.next());
            if(oddIterator.hasNext()) {
                System.out.print(",");
            }
        }
        if(evenIterator.hasNext() && flag) {
            System.out.print(",");
        }
        while (evenIterator.hasNext()){
            System.out.print(evenIterator.next());
            if(evenIterator.hasNext()) {
                System.out.print(",");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] array = str.split(",");

//        solution1(array);
        solution2(array);
    }
}
