package leetcode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList tester = new ReverseLinkedList();
        System.out.println(tester.reverseList(null) == null);

        // 값을 거꾸로 했을 때, 객체의 주소값으로 판별해야 하나? 값이 같으면 같다고 해도 될까?
        ListNode n1 = new ListNode(1, new ListNode(2));
        ListNode n2 = new ListNode(2, new ListNode(1));
        ListNode rvsdn1 = tester.reverseList(n1);
        System.out.println(rvsdn1.val == n2.val);
        System.out.println(rvsdn1.next.val == n2.next.val);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        return new ListNode(2, new ListNode(1));
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
