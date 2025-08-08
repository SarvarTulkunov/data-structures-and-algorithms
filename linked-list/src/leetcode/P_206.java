package leetcode;

/**
 * 206. Reverse Linked List
 */
public class P_206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current_node = head;
        ListNode temp;
        while (current_node != null) {
            temp = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = temp;
        }

        return prev;
    }

}
