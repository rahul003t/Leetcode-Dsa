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
    public ListNode reverseList(ListNode head) {
        
    ListNode cur = head;
    
    ListNode prev = null;
    
    while(cur!=null)
    {
        ListNode forw = cur.next;
        cur.next = prev;
        prev = cur;
        cur = forw;
    }
    
    return prev;
        
    }
}