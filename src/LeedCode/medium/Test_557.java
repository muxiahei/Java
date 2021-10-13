package LeedCode.medium;

import java.util.Arrays;

public class Test_557 {

    public static String reverseWords(String s) {

        StringBuilder string = new StringBuilder();

        String[] array = s.split(" ");

        for(String substring : array) {
            StringBuilder sub = new StringBuilder(substring);
            string.append(sub.reverse().toString()).append(" ");
        }
        return String.valueOf(string);

    }

    public static String reverseWords2(String s) {

        StringBuilder string = new StringBuilder();

        String[] array = s.split(" ");

        for (int j = 0; j < array.length; j++) {
            String[] array2 = array[j].split("");

            for(int i = 0; i < array2.length / 2; i++) {
                String temp = array2[i];
                array2[i] = array2[array2.length - i - 1];
                array2[array2.length - i - 1] = temp;
            }

            for(int i = 0; i < array2.length; i++) {
                string.append(array2[i]);
            }
            if(j < array.length - 1) {
                string.append(" ");
            }
        }
        return String.valueOf(string);
    }

    public static void main(String[] args) {

        System.out.println(reverseWords("abc efg"));
        System.out.println(reverseWords2("abc efg"));

    }
}
