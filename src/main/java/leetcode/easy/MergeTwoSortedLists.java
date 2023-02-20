package leetcode.easy;

public class MergeTwoSortedLists {
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
}

