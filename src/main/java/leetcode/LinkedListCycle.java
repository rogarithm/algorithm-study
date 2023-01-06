package leetcode;

// Given head, the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by
// continuously following the next pointer. Internally, pos is used to denote the index of the node
// that tail's next pointer is connected to. Note that pos is not passed as a parameter.
// Return true if there is a cycle in the linked list. Otherwise, return false.

public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle tester = new LinkedListCycle();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);

        System.out.println(tester.hasCycle(l1) == false);
        System.out.println(tester.hasCycle(l2) == true);
    }

    public boolean hasCycle(ListNode head) {
        if (head.next == null)
            return false;
        return true;
    }

    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
