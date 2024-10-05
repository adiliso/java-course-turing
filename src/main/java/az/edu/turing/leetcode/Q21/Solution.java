package az.edu.turing.leetcode.Q21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //https://leetcode.com/problems/merge-two-sorted-lists/description/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                cur.next = new ListNode(list1.val);
                cur = cur.next;
                list1 = list1.next;
            }else {
                cur.next = new ListNode(list2.val);
                cur = cur.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            cur.next = new ListNode(list1.val);
            cur = cur.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            cur.next = new ListNode(list2.val);
            cur = cur.next;
            list2 = list2.next;
        }
        return head.next;
    }
}