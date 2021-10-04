package HomeWork.Test02;

import java.util.Scanner;

public class CircularLinkedListSort {

    static Node create() {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Node head;
        head = new Node(Integer.MAX_VALUE);
        head.setNext(null);

        Node curr = head;

        for(int i = 1; i <= num; i++) {
            final int n = scanner.nextInt();
            Node newNode = new Node(n);
            curr.setNext(newNode);
            newNode.setPrior(curr);
            curr = newNode;
        }
        curr.setNext(head);
        head.setPrior(curr);
        return head;
    }

    static Node insert(Node head,int index, int data) {
        Node newNode = new Node(data);
        Node curr = head.getNext();

        int k = 0;
        while (curr != head && k < index-1) {
            curr = curr.getNext();
            k++;
        }
        if(curr.getData() == Integer.MAX_VALUE) {
            curr.setPrior(newNode);
            newNode.setNext(curr);
        }else {
            newNode.setNext(curr.getNext());
            curr.getNext().setPrior(newNode);
            newNode.setPrior(curr);
            curr.setNext(newNode);
        }


        return head;
    }

    static Node sort(Node head) {
        int i = 1;
        Node curr = head.getNext();
        Node next = curr.getNext();
        while (next != curr && curr.getData() > next.getData()) {
            next = next.getNext();
            i++;
        }
        head = insert(head,i,curr.getData());
        return head;
    }

    static Node delete(Node head,int index) {
        int k = 0;
        Node curr = head;
        while(curr.getNext() != head && k< index) {
            curr = curr.getNext();
            k++;
        }
        head.setNext(curr.getNext());
        curr.getNext().setPrior(head);
        return head;
    }

    static void show(Node head) {
        Node curr = head;
        Node next = curr.getNext();
        while(curr != next) {
            System.out.print(next.getData() + " ");
            next = next.getNext();
        }
    }

    public static void main(String[] args) {
        Node head = create();
        head = sort(head);

        head = delete(head,1);
        show(head);
    }
}

class Node {
    private int data;
    private Node prior;
    private Node next;
    private int size;

    Node() {

    }
    Node(int data) {
        this.data = data;
    }
    Node(int data,Node prior,Node next) {
        this.prior = prior;
        this.next = next;
        this.data= data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrior() {
        return prior;
    }

    public void setPrior(Node prior) {
        this.prior = prior;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
