package leetcode.easy;

// Given head, the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by
// continuously following the next pointer. Internally, pos is used to denote the index of the node
// that tail's next pointer is connected to. Note that pos is not passed as a parameter.
// Return true if there is a cycle in the linked list. Otherwise, return false.

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle tester = new LinkedListCycle();
        ListNode l1 = new ListNode(1);
        System.out.println(tester.hasCycle(l1) == false);

        ListNode l2 = new ListNode(1);
        ListNode l2Next = new ListNode(2);
        l2.next = l2Next;
        l2Next.next = l2;
        System.out.println(tester.hasCycle(l2) == true);

        ListNode l3 = new ListNode(1);
        ListNode l3Next = new ListNode(2);
        l3.next = l3Next;
        System.out.println(tester.hasCycle(l3) == false);
    }

    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> cache = new HashMap<>();
        boolean result = false;

        if (head == null) {
            return result;
        }

        if (head != null) {
            cache.put(head, true);
        }

        ListNode nextElement = head.next;
        while (nextElement != null) {
            if (cache.get(nextElement) == null) {
                cache.put(nextElement, true);
            } else if (cache.get(nextElement) != null && cache.get(nextElement) == true) {
                result = true;
                break;
            }
            nextElement = nextElement.next;
        }

        return result;
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