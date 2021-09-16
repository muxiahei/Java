package DataStructures.Lists;

public class SinglyLinkedList {
    private Node head;

    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }


    SinglyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public void insertHead(int data, int position) {
        insertNth(data,position);
    }

    public void deleteHead() {
        deleteNth(0);
    }

    public void delete() {

    }

    public boolean search(int key) {
        Node cur = head;
        while (cur.next != null) {
            if(cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void insertNth(int data, int position) {
        checkBounds(position,0,size);
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            size ++;
            return;
        } else if(position == 0) {
            newNode.next = head;
            head = newNode;
            size ++;
            return;
        }
        Node cur = head;
        for(int i = 0; i < position-1; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size ++;
    }

    public void deleteNth(int position) {
        checkBounds(position,0,size - 1);
        if(position == 0) {
            Node destroy = head;
            head = head.next;
            destroy = null;
            size--;
        }
        Node cur = head;
        for(int i = 0; i < position - 1; i++) {
            cur = cur.next;
        }
        Node destry = cur;
        cur.next = cur.next.next;
        destry = null;
        size--;
    }



    public void checkBounds(int position, int low, int high) {
        if(position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }
}


class Node {
    int value;
    Node next;
    Node(){

    }
    Node(int value) {
        this(value,null);
    }
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
