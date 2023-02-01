package leetcode;

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
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
