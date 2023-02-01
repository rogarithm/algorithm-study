package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList tester = new PalindromeLinkedList();
        System.out.println(tester.isPalindrome(null) == false);
        System.out.println(tester.isPalindrome(new ListNode(1)) == false);
        ListNode t1 = new ListNode(1, new ListNode(1));
        System.out.println(tester.isPalindrome(t1) == true);
        ListNode t2 = new ListNode(1, new ListNode(2));
        System.out.println(tester.isPalindrome(t2) == false);
        ListNode t3 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(tester.isPalindrome(t3) == true);

    }

    // Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        int length = 0;
        ListNode firstNode = head;
        while (head != null) {
            head = head.next;
            length++;
        }
        head = firstNode; // 노드가 처음을 가리키도록 되돌린다

        // 노드 갯수가 홀수이면 palindrome일 수 없다
        if (length % 2 == 1) {
            return false;
        }

        // 노드 갯수가 짝수이면 전체 노드 중 앞의 반과 뒤의 반을 비교한다
        int halfLength = length / 2;
        Deque<Integer> half = new ArrayDeque<>();

        for (int i = 0; i < halfLength; i++) {
            half.addFirst(head.val);
            head = head.next;
        }

        for (int i = halfLength; i < length; i++) {
            if (half.removeFirst() != head.val)
                return false;
            head = head.next;
        }

        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
