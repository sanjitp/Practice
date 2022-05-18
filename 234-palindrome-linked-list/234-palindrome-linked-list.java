/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode left;
    public boolean helper(ListNode head)
    {
        if(head==null)
            return true;
        
        boolean res= helper(head.next);
       if(res==false)
           return false;
        boolean isp=(left.val==head.val);
        left=left.next;
        return isp;
    }
    public boolean isPalindrome(ListNode head) {
        left=head;
        if(head==null)
            return false;
        if(head.next==null)
            return true;
        boolean res= helper(head);
        return res;
    }
}