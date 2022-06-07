/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        if(head.next==null)
            return false;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            if(slow.next!=null)slow=slow.next;
            if(fast.next.next!=null) fast=fast.next.next;
             if(fast==slow)return true;
        }
       
        return false;
        
        
    }
}