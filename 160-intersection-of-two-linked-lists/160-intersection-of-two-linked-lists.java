/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1=0;
        int c2=0;
        ListNode temp=headA;
        while(temp!=null)
        {
            temp=temp.next;
            c1++;
        }
        temp=headB;
        while(temp!=null)
        {
            temp=temp.next;
            c2++;
        }
        ListNode list1=headA;
        ListNode list2=headB;
        
        int diff=c1-c2;
        
        if(diff<0)
            while(diff++!=0)
             list2=list2.next;
        else 
            while(diff--!=0)
                list1=list1.next;
        while(list1!=null)
        {
            if(list1==list2)return list1;
            list1=list1.next;
            list2=list2.next;
        }
       return list1; 
    }
}