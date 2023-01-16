package leetcode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList tester = new ReverseLinkedList();
        System.out.println(tester.reverseList(null) == null);
    }

    public ListNode reverseList(ListNode head) {
        return null;
    }

    private static class ListNode {

        int val;
        leetcode.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, leetcode.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
