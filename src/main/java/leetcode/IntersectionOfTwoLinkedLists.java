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
