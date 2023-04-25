package by.leetcode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var result = new ListNode();
        var currentNode = result;
        while (l1 != null || l2 != null) {
            var initialVal = 0;
            var sum = currentNode.val + getValue(l1) + getValue(l2);
            if (sum - 10 >= 0) {
                currentNode.val = sum - 10;
                initialVal = 1;
            } else {
                currentNode.val = sum;
            }
            if (initialVal != 0 || (l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
                currentNode.next = new ListNode(initialVal);
                currentNode = currentNode.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return result;
    }

    private int getValue(final ListNode node) {
        return node != null ? node.val : 0;
    }

}
