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
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(slow!=null && fast!=null)
        {
            if(slow.next!=null)
                slow=slow.next;
                fast=fast.next;
            if(fast!=null)
            fast=fast.next;
            if(fast==slow)
            break;
        }
        if(fast==null)
            return null;
        slow=head;
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
        
   }
}