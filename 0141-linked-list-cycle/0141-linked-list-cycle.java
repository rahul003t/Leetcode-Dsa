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
        
//         ListNode slow = head;
//         ListNode fast = head.next;
        
//         while(slow != null && fast != null && slow!=fast)
//         {
           
//             slow = slow.next;
//             fast = fast.next;
            
//             if(fast.val == slow.val)
//             {
//                 return true;
//             }
//         }
//         if( slow == null || fast == null)
//         {
//             return false;
//         }
        
        
//         return true;
        
        ListNode slow=head;
        ListNode fast = head;
        
        while(fast!= null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
            {
                return true;
            }
        }
        return false;
    }
}