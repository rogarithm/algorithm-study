package leetcode;

// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists
// intersect. If the two linked lists have no intersection at all, return null.
// The test cases are generated such that there are no cycles anywhere in the entire linked structure.
// Note that the linked lists must retain their original structure after the function returns.

import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists tester = new IntersectionOfTwoLinkedLists();
        System.out.println(tester.getIntersectionNode(null, null) == null);
        System.out.println(tester.getIntersectionNode(new ListNode(1), null) == null);
        System.out.println(tester.getIntersectionNode(null, new ListNode(1)) == null);

        ListNode intersect1 = new ListNode(3);
        ListNode head1 = new ListNode(1);
        head1.next = intersect1;
        ListNode head2 = new ListNode(2);
        head2.next = intersect1;
        System.out.println(tester.getIntersectionNode(head1, head2) == intersect1);

        ListNode intersect2 = new ListNode(8);
        intersect2.next = new ListNode(4);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        a1.next = a2;
        a2.next = intersect2;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);
        b1.next = b2;
        b2.next = b3;
        b3.next = intersect2;
        System.out.println(tester.getIntersectionNode(a1, b1) == intersect2);
    }

    // 교차하는 노드는 두 ListNode가 공유하는 노드여야 한다. 즉 같은 객체여야 한다.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // 매개변수 중 한쪽 listnode를 hashmap에 저장한다
        Map<ListNode, Boolean> cache = new HashMap<>();
        ListNode key = headA;
        while (key != null) {
            cache.put(key, true);
            key = key.next;
        }

        // 남은 매개변수의 listnode를 스캔하면서 공유하는 노드가 있는지(같은 객체가 있는지) 확인한다
        ListNode candidate = headB;
        while (candidate != null) {
            if (cache.get(candidate) != null && cache.get(candidate) == true) {
                return candidate;
            }
            candidate = candidate.next;
        }

        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
