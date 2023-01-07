package leetcode;

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
        System.out.println(tester.getListNodeLength(l1) == false);

        ListNode l2 = new ListNode(1);
        ListNode l2Next = new ListNode(2);
        l2.next = l2Next;
        l2Next.next = l2;
        System.out.println(tester.hasCycle(l2) == true);
        System.out.println(tester.getListNodeLength(l2) == true);

        ListNode l3 = new ListNode(1);
        ListNode l3Next = new ListNode(2);
        l3.next = l3Next;
        System.out.println(tester.hasCycle(l3) == false);
        System.out.println(tester.getListNodeLength(l3) == false);
    }

    public boolean hasCycle(ListNode head) {
        if (head.next == null) // 재귀함수로 만들 경우에도 이 조건이 유효한가? 유효하다. 유효한 순환 LinkedList는 모든 ListNode가 next 필드를 가져야 한다.
            return false;
        // 마지막 요소인지 판별할 수 있는 조건이 있나? 순회하는 요소 목록을 기록해야 할까?
        // 문제에서 제시하는 것처럼 인덱스 값을 추가할 수 있다면 마지막인지 판별할 수 있을 것 같다.
        // 객체 주소가 같은지를 비교하면 값이 같더라도 다른 노드인지 확인할 수 있을 것 같다.
        if (head.next.next == null)
            return false;
        else
            return true;
    }

    private boolean getListNodeLength(ListNode head) {
        Map<ListNode, Boolean> cache = new HashMap<>();
        boolean result = false;

        if (head != null) {
            cache.put(head, true);
        }

        ListNode nextElement = head;
        while (nextElement.next != null) {
            nextElement = nextElement.next;
            if (cache.get(nextElement) == null) {
                cache.put(nextElement, true);
            }
            else if (cache.get(nextElement) != null && cache.get(nextElement) == true) {
                result = true;
                break;
            }
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
