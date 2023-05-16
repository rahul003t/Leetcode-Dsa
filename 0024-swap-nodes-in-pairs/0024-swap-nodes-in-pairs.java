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
    public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null) return head;

        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode t1 = head;
        while(t1!=null){
            arr.add(t1);
            t1 = t1.next;
        }

        ArrayList<ListNode> brr = new ArrayList<>();
        for(int i=0;i<arr.size();i+=2){
            try{ brr.add(arr.get(i+1)); }catch(Exception e){}
            try{ brr.add(arr.get(i)); }catch(Exception e){}
        }
        ListNode ans = brr.get(0);
        ListNode h = brr.get(0);
        for(int i=1;i<brr.size();i++){
            ans.next = brr.get(i);
            ans = brr.get(i);
        }

        ans.next = null;
        return h;

    }
}