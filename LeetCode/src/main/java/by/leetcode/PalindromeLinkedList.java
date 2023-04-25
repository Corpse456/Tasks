package by.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        final var list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int begin = 0, end = list.size() - 1, halfArray = list.size() / 2;
        while (begin <= halfArray) {
            if (!list.get(begin++).equals(list.get(end--))) {
                return false;
            }
        }

        return true;
    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int... val) {
        this.val = val[0];
        if (val.length > 1) {
            final var values = Arrays.stream(val).skip(1).toArray();
            this.next = new ListNode(values);
        }
    }
}
