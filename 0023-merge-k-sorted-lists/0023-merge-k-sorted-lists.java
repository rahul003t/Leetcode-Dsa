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
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        int interval = 1;
        while(interval<length)
        {
            for(int i=0;i<length-interval;i+=interval*2)
            {
                mergeSort(lists,i,i+interval);
            }
            interval*=2;
        }

        return length>0?lists[0]:null;
    }

    public void mergeSort(ListNode[] lists,int left,int right)
    {
        ListNode leftNode = lists[left];
        ListNode rightNode = lists[right];

        ListNode newNode = new ListNode();
        ListNode head = newNode;
        while(leftNode!=null&&rightNode!=null)
        {
            if(leftNode.val>rightNode.val)
            {
                head.next = new ListNode(rightNode.val);
                rightNode = rightNode.next;
            }
            else{
                head.next = new ListNode(leftNode.val);
                leftNode = leftNode.next;
            }
            head = head.next;
        }

        while(leftNode!=null)
        {
            head.next = new ListNode(leftNode.val);
            leftNode = leftNode.next;
            head = head.next;
        }
        while(rightNode!=null)
        {
            head.next = new ListNode(rightNode.val);
            rightNode = rightNode.next;
            head = head.next;
        }
        lists[left] = newNode.next;
    }
}