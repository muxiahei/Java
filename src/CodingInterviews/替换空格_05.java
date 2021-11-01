package CodingInterviews;

/**
 *
 */
public class 替换空格_05 {
    public static void main(String[] args) {
        String s = "We are haapy";
        String[] array = s.split(" ");

        for (int i = 0; i < array.length; i++) {
            if (array[i] == "") {
                array[i] = "%20";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < array.length; j++) {
            System.out.print(stringBuilder.append(array[j]));
        }
        return;
    }
}
