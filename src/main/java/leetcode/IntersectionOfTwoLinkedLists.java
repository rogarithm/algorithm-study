package leetcode;

// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists
// intersect. If the two linked lists have no intersection at all, return null.
// The test cases are generated such that there are no cycles anywhere in the entire linked structure.
// Note that the linked lists must retain their original structure after the function returns.

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists tester = new IntersectionOfTwoLinkedLists();
        System.out.println(tester.getIntersectionNode(null, null) == null);
        System.out.println(tester.getIntersectionNode(new ListNode(1), null) == null);
        System.out.println(tester.getIntersectionNode(null, new ListNode(1)) == null);
    }

    // 교차하는 노드는 두 ListNode가 공유하는 노드여야 한다. 즉 같은 객체여야 한다.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
