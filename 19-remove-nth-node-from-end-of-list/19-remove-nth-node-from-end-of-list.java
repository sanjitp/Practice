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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        ListNode temp=head;
        int len=0;
        while(temp!=null)
        {
            temp=temp.next;
            len++;
        }
        temp=head;
        len=len-n;
        if(len==0)
            return head.next;
        ListNode prev=null;
        while(len>0)
        {
            prev=temp;
            temp=temp.next;
            len--;
        }
        prev.next=temp.next;
        return head;
    }
    
}