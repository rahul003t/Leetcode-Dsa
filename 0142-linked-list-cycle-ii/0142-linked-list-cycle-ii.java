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
    
    Set<ListNode> visited = new HashSet<>();
    public ListNode detectCycle(ListNode head) {
        if(head == null)
        {
            return null;
        }
        
        if(visited.contains(head))
        {
            return head;
        }
        
        visited.add(head);
        
        return detectCycle(head.next);
    }
}