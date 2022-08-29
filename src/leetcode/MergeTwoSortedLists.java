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

        // System.out.println(new ListNode().next == null);
        // 빈 ListNode는 어떻게 만들지?
        // 두 빈 ListNode를 비교할 때 주소값 이외 요소로 비교하려면?
        // 문자열로 확인하려면 어떻게 해야 하지?
    }

    // new ListNode()로 빈 노드를 만들면 val 값이 0인데 []로 빈 값은 어떤 경우지?
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // null 체크를 어떻게 나누고 뭘 먼저 해야 할까?
        // 한쪽만 null인 경우, 둘 다 null인 경우
        ListNode result = null;
        if (list1 == null && list2 == null) {
            // 두 노드가 비었으면 빈 노드를 반환
            result = null;
        }
        // 두 노드 중 하나는 뒤에 값이 있다면 값 하나만 있는 노드의 값이 어디 들어갈지 계산해야 한다
        // 하지만 이 작업은 아래서 해준다.
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
        // ListNode는 정렬되어 있다. 어떤 값을 더 앞에 붙일지 어떻게 결정할까?
        // A.val, B.val을 비교해보고, 값이 같으면 한쪽을 next로 바꿔서 비교한다
        // 어느 한쪽이 작다면, 큰 쪽의 모든 요소는 작은 요소보다 크다
        else if (list1.val <= list2.val) {
            // list1.val이 맨 앞에 온다. 남은 건 mergeTwoLists에 넣어 계산한다
            // mergeTwoLists()를 재귀로 계산하더라도 이전 계산 결과를 유지하려면 어디에 둬야 할까?
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

