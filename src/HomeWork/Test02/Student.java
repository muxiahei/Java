package HomeWork.Test02;

import java.util.Scanner;

public class Student {

    private int num;
    private int score;
    private Student next;

    Student(int num, int score) {
        this.num = num;
        this.score = score;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[num=" + num + ",score=" + score + "]";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String next = scanner.nextLine();
        final String[] students = next.split(" ");

        Student head = null;
        Student tail = null;

        for (int i = 0; i < students.length; i++) {

            String[] split = students[i].split(",");
            final Student student = new Student(Integer.valueOf(split[0]), Integer.valueOf(split[1]));

            if(head == null && tail == null) {
                head = student;
                tail = student;
            }else {
                tail.next = student;
                tail = tail.next;
            }
        }
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }
}
