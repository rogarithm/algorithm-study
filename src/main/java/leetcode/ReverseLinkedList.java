package leetcode;

import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList tester = new ReverseLinkedList();
        System.out.println(tester.reverseList(null) == null);

        // 값을 거꾸로 했을 때, 객체의 주소값으로 판별해야 하나? 값이 같으면 같다고 해도 될까?
        ListNode n1 = new ListNode(1, new ListNode(2));
        ListNode n2 = new ListNode(2, new ListNode(1));
        ListNode rvsdn1 = tester.reverseList(n1);
        //System.out.println(rvsdn1.val == n2.val);
        //System.out.println(rvsdn1.next.val == n2.next.val);

        ListNode n3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode rvsdn3 = tester.reverseList(n3);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        // head의 첫 요소가 result의 마지막으로 가야 한다
        // 다른 자료구조에 head 안 요소를 담아두고, 끝부터 result에 넣으면 어떨까?
        Stack<Integer> acc = new Stack<>();
        while (head != null) {
            acc.push(head.val);
            head = head.next;
        }

        ListNode result = new ListNode();
        while (!acc.isEmpty()) {
            System.out.print(acc.pop() + " ");
        }
        System.out.println();

        return new ListNode();
    }

    private static class ListNode {

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

}
