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
    //Set<ListNode> visited = new HashSet<>();
    public boolean hasCycle(ListNode head) {
        
        if(head == null)
        {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != null && fast != null && slow!=fast)
        {
           
            slow = slow.next;
            fast = fast.next;
            
            if(fast != null)
            {
                fast =fast.next;
            }
        }
        if( slow == null || fast == null)
        {
            return false;
        }
        
        
        return true;
    }
}