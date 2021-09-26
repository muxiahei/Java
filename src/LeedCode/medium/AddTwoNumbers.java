package LeedCode.medium;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public static ListNode solution(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode();
        ListNode newNode = new ListNode();
        l3.next = newNode;
        boolean flag = false;

        while (l1 != null || l2 != null || flag) {

            if(flag) {
                newNode.val = 1;
            } else {
                newNode.val = 0;
            }

            int num1 = l1 == null ? 0:l1.val;
            int num2 = l2 == null ? 0:l2.val;

            if(num1 + num2 + newNode.val >= 10) {
                flag = true;
                newNode.val = newNode.val + num1 + num2 - 10;
            }else {
                flag = false;
                newNode.val = newNode.val + num1 + num2;
            }

            l1 = l1 == null ? null:l1.next;
            l2 = l2 == null ? null:l2.next;

            if(l1 != null || l2 != null || flag) {
                ListNode newNode2 = new ListNode();
                newNode.next = newNode2;
                newNode = newNode2;
            }


        }
        l3 = l3.next;

        return l3;
    }

    public static void main(String[] args) {
        final ListNode listNode1 = new ListNode(2);
        final ListNode listNode2 = new ListNode(4);
        final ListNode listNode3 = new ListNode(3);
//        final ListNode listNode10 = new ListNode(9);

        final ListNode listNode4 = new ListNode(5);
        final ListNode listNode5 = new ListNode(6);
        final ListNode listNode6 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode10;


        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = solution(listNode1, listNode4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
