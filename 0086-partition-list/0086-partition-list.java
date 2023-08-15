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
    public ListNode partition(ListNode head, int x) {
        ListNode current = head;  // Pointer to traverse the original list
        
        ListNode lessDummy = new ListNode(0);    // Dummy node for nodes < x
        ListNode lessTail = lessDummy;           // Tail pointer for less list
        
        ListNode greaterDummy = new ListNode(0); // Dummy node for nodes >= x
        ListNode greaterTail = greaterDummy;     // Tail pointer for greater list
        
        // Traverse the original list
        while (current != null) {
            if (current.val < x) {
                // Append current node to the less list
                lessTail.next = new ListNode(current.val);
                lessTail = lessTail.next; // Move the tail pointer
            } else {
                // Append current node to the greater list
                greaterTail.next = new ListNode(current.val);
                greaterTail = greaterTail.next; // Move the tail pointer
            }
            current = current.next; // Move to the next node
        }
        
       
        
        // Attach the greater list to the end of the less list
        lessTail.next = greaterDummy.next;
        
        // Return the modified list starting from the first node after the less dummy node
        return lessDummy.next;
    }
}
