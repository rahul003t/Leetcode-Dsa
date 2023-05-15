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
    public ListNode swapNodes(ListNode head, int k) {

        if(head == null || head.next == null)
            return head;

        int n = 0;
        ListNode pre = head;
        while(pre!=null){
            pre = pre.next;
            n+=1;
        }

        //If length of linked list is equal to k
        //then simply swap the head and tail nodes
        if(k == n){
            ListNode temp = head,prev = null;


            while(temp.next != null){
                prev = temp;
                temp = temp.next;
            }

            prev.next = head;
            temp.next = head.next;
            head.next = null;
            head = temp;
            return head;
        }


        //Calculating the kth node from first

        int count = k;
        ListNode front = head,prev1 = null;

        while(count>1){
            prev1 = front;
            front = front.next;
            count-=1;
        }



        //calculating the kth node from end
        ListNode gap = head;
        count = k;

        while(count>0){
            gap = gap.next;
            count-=1;
        }
        ListNode back = head,prev2 = null;
        while(gap != null){
            prev2 = back;
            gap = gap.next;
            back = back.next;
        }

        if(prev1 != null)
            prev1.next = back;
        if(prev2 != null)
            prev2.next = front;
        
        ListNode next = front.next;    
        front.next = back.next;
        back.next = next;
        
        if(k == 1)
            return back;


        return head;
    }
}