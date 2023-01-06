package leetcode;

// Given head, the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by
// continuously following the next pointer. Internally, pos is used to denote the index of the node
// that tail's next pointer is connected to. Note that pos is not passed as a parameter.
// Return true if there is a cycle in the linked list. Otherwise, return false.

public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle tester = new LinkedListCycle();
        System.out.println(tester.hasCycle(new ListNode(1)) == false);
    }

    public boolean hasCycle(ListNode head) {
        return false;
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
