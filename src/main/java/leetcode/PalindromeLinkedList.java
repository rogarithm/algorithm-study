package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList tester = new PalindromeLinkedList();
        ListNode t1 = new ListNode(1, new ListNode(1));
        System.out.println(tester.isPalindrome(t1) == true);
        ListNode t2 = new ListNode(1, new ListNode(2));
        System.out.println(tester.isPalindrome(t2) == false);
    }

    // Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    public boolean isPalindrome(ListNode head) {
        // 노드 갯수가 홀수이면 palindrome일 수 없다
        if (head == null) {
            return false;
        }

        int length = 0;
        ListNode nodeForLength = head;
        while (nodeForLength != null) {
            nodeForLength = nodeForLength.next;
            length++;
        }
        System.out.println(length);

        if (length % 2 == 1) {
            return false;
        }

        // 노드 갯수가 짝수이면 전체 노드 중 앞의 반과 뒤의 반을 비교한다
        int halfLength = length / 2;
        Deque<Integer> half = new ArrayDeque<>();

        for (int i = 0; i < halfLength; i++) {
            half.push(head.val);
            head = head.next;
        }

        for (int i = halfLength; i < length; i++) {
            if (half.pop() != head.val)
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
