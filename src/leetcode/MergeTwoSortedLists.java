import java.util.LinkedList;

// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists test = new MergeTwoSortedLists();

        // test 1
        System.out.println(test.mergeTwoLists(new ListNode(), new ListNode()));

        // test 2
        // ListNode l0 = new ListNode();
        // ListNode l1 = new ListNode(0);
        // ListNode test2 = test.mergeTwoLists(l0, l1);
        // System.out.println(test2.val + "|" + test2.next);

        // test 3
        // ListNode two = new ListNode(2);
        // ListNode one = new ListNode(1);
        // ListNode test3 = test.mergeTwoLists(one, two);
        // System.out.println(test3.val + " " + test3.next.val);

        // test 4
        // ListNode l3 = new ListNode(3);
        // ListNode l1 = new ListNode(1, l3);
        // ListNode l24 = new ListNode(4);
        // ListNode l22 = new ListNode(2, l24);
        // ListNode test4 = test.mergeTwoLists(l1, l22);
        // System.out.println(test4.val);
        // System.out.println(test4.next.val);
        // System.out.println(test4.next.next.val);
        // System.out.println(test4.next.next.next.val);

        // test 5
        // ListNode l4 = new ListNode(4);
        // ListNode l2 = new ListNode(2, l4);
        // ListNode l1 = new ListNode(1, l2);
        // ListNode l24 = new ListNode(4);
        // ListNode l23 = new ListNode(3, l24);
        // ListNode l21 = new ListNode(1, l23);
        // ListNode test5 = test.mergeTwoLists(l1, l21);
        // System.out.println(test5.val);
        // System.out.println(test5.next.val);
        // System.out.println(test5.next.next.val);
        // System.out.println(test5.next.next.next.val);
        // System.out.println(test5.next.next.next.next.val);
        // System.out.println(test5.next.next.next.next.next.val);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        // 두 노드 모두 비었을 경우
        if (list1 == null && list2 == null) {
            result = null;
        }
        // 두 노드 중 하나만 비었을 경우
        else if (list1 == null || list2 == null) {
            ListNode nonEmptyNode = list1 == null ? list2 : list1;
            result = new ListNode(nonEmptyNode.val, nonEmptyNode.next);
        }
        else if (list1.next == null && list2.next == null) {
            // 두 노드 다 값 하나씩만 있을 경우 순서에 맞춰 노드를 만든다
            int smaller = list1.val <= list2.val ? list1.val : list2.val;
            int bigger = list1.val <= list2.val ? list2.val : list1.val;
            result = new ListNode(smaller, new ListNode(bigger));
        }
        // ListNode는 정렬되어 있다. 어느 한쪽이 작다면, 큰 쪽의 모든 요소는 작은 요소보다 크다
        else if (list1.val <= list2.val) {
            // list1.val이 맨 앞에 온다. 남은 건 mergeTwoLists에 넣어 계산한다
            result = new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        }
        else if (list1.val > list2.val) {
            // list2.val을 list1.val 앞에 놓고 나머지를 계산한다
            result = new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return super.toString();
    }
}

